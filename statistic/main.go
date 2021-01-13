package main

import (
	"bytes"
	"encoding/json"
	"errors"
	"fmt"
	"gopkg.in/yaml.v2"
	"io/ioutil"
	"log"
	"net/http"
	"net/url"
	"regexp"
	"strconv"
	"strings"
	"time"
)

type apiCallResult struct {
	StartTime                          string  `yaml:"start-time"`
	GrpcServiceExecutionDuration       float64 `yaml:"grpc-service-execution-duration"`
	GrpcServiceExecutionPrettyDuration string  `yaml:"grpc-service-execution-pretty-duration"`
	Iterations                         int
	ChunkOperationDelay                int    `yaml:"chunk-operation-delay"`
	EndTime                            string `yaml:"end-time"`
}

type apiCall struct {
	ApiCallUrl string `yaml:"url"`
	Result     apiCallResult
	Error      string
}

type statisticGroupResult struct {
	Group   statisticVariable
	Results []apiCall
}

type statisticResult struct {
	StatisticGroupsResult []statisticGroupResult `yaml:"statistic-groups-result"`
}

type statisticVariable struct {
	Elements   int32
	Iterations int8
	ChunkDelay int8 `yaml:"chunk-delay"`
}

type configuration struct {
	Protocol           string
	Host               string
	Port               int32
	StatisticApi       []string            `yaml:"statistic-api"`
	StatisticVariables []statisticVariable `yaml:"statistic-variables"`
}

func main() {
	var config configuration

	config.readConfiguration()

	collectStatistic(&config)
}

func (configuration *configuration) readConfiguration() *configuration {
	file, err := ioutil.ReadFile("statistic-config.yaml")
	if err != nil {
		log.Fatalf("yamlFile.Get err #%v", err)
	}
	err = yaml.Unmarshal(file, configuration)
	if err != nil {
		log.Fatalf("Unmarshal: %v", err)
	}
	return configuration
}

func collectStatistic(configuration *configuration) {
	start := time.Now()
	endpoint, err := prepareURL(configuration)
	if err != nil {
		log.Fatalf("URL prepartation failed %v", err)
	}
	callMap, totalElements := createApiCallMap(configuration, *endpoint)
	log.Printf("Total tests: %v\n", totalElements)
	result := statisticResult{
		StatisticGroupsResult: []statisticGroupResult{},
	}

	for variable, urls := range callMap {
		var totalCount = 0
		groupResult := statisticGroupResult{
			Group:   variable,
			Results: []apiCall{},
		}
		for _, urlValue := range urls {
			fmt.Printf("\nProccessing url: %v\n", urlValue.String())
			quit := make(chan bool)
			go func() {
				processingTime := int((variable.Elements / 500 * int32(variable.ChunkDelay)) * int32(variable.Iterations))
				endTime := processingTime
				fmt.Printf("Expected processing time: %vs\n", processingTime)
				for {
					select {
					case <-quit:
						return
					default:
						fmt.Printf("\rProccessing will end in: %vs", endTime)
						time.Sleep(1 * time.Second)
						endTime -= 1
					}
				}
			}()
			lastCallStartTime := time.Now()
			groupResult.Results = append(groupResult.Results, executeApiCall(urlValue))
			quit <- true
			totalCount += 1
			percentage := float64(100) / float64(totalElements) * float64(totalCount)
			fmt.Printf("\rOn %d/%d - %.2f%%. Duration - %.2fs. Total Duration - %.2fs", totalCount, totalElements, percentage,
				time.Now().Sub(lastCallStartTime).Seconds(),
				time.Now().Sub(start).Seconds())
		}
		result.StatisticGroupsResult = append(result.StatisticGroupsResult, groupResult)
	}
	marshal, err := yaml.Marshal(result)
	if err != nil {
		log.Fatalf("Error happens during mashaling %v", err)
	}
	err = ioutil.WriteFile("statistic-result.yaml", marshal, 0775)
	if err != nil {
		log.Fatalf("Could not write data to the file %v", err)
	}
}

func prepareURL(configuration *configuration) (*url.URL, error) {
	protocol := configuration.Protocol
	URL := url.URL{}
	if matched, err := regexp.Match("^(http|https)$", []byte(protocol)); !matched || err != nil {
		if err == nil {
			err = errors.New("protocol is not valid. Valid values: http and https")
		}
		return &URL, err
	}
	host := configuration.Host
	if strings.EqualFold(host, "") {
		return &URL, errors.New("host should not be null")
	}
	host = strings.TrimSuffix(host, "/")
	host = strings.TrimPrefix(host, "/")
	if configuration.Port <= 0 {
		return &URL, errors.New("port is not valid")
	}
	return URL.Parse(protocol + "://" + host + ":" + strconv.Itoa(int(configuration.Port)))
}

func createApiCallMap(configuration *configuration, endpoint url.URL) (map[statisticVariable][]url.URL, int) {
	dataMap := make(map[statisticVariable][]url.URL)
	var counter = 0
	for _, api := range configuration.StatisticApi {
		var newUrl = endpoint
		newUrl.Path = api
		for _, testVariable := range configuration.StatisticVariables {
			var queryUrl = newUrl
			query := queryUrl.Query()
			if testVariable.Elements > 0 {
				query.Set("elements", strconv.Itoa(int(testVariable.Elements)))
			}
			if testVariable.Iterations > 0 {
				query.Set("iterations", strconv.Itoa(int(testVariable.Iterations)))
			}
			if testVariable.ChunkDelay > 0 {
				query.Set("delay", strconv.Itoa(int(testVariable.ChunkDelay)))
			}
			queryUrl.RawQuery = query.Encode()
			counter += 1
			urls := dataMap[testVariable]
			if len(urls) == 0 {
				var emptySlice []url.URL
				dataMap[testVariable] = emptySlice
			}
			dataMap[testVariable] = append(urls, queryUrl)
		}
	}
	return dataMap, counter
}

func executeApiCall(urlValue url.URL) apiCall {
	stringUrlValue := urlValue.String()
	get, err := http.Get(stringUrlValue)
	apiCall := apiCall{
		ApiCallUrl: stringUrlValue}
	if err != nil {
		apiCall.Error = err.Error()
		return apiCall
	}
	if get == nil {
		apiCall.Error = "get response is nil"
		return apiCall
	}
	buf := new(bytes.Buffer)
	_, err = buf.ReadFrom(get.Body)
	if err != nil {
		apiCall.Error = err.Error()
		return apiCall
	}
	body := buf.String()
	if get.StatusCode != 200 {
		apiCall.Error = fmt.Sprintf("api call apiCall is not 200 %v", body)
		return apiCall
	}
	result := apiCallResult{}
	err = json.Unmarshal([]byte(body), &result)
	if err != nil {
		apiCall.Error = err.Error()
		return apiCall
	}
	apiCall.Result = result
	return apiCall
}
