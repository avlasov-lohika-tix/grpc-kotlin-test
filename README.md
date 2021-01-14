# GRPC StreamObservers examples

## Description

The repository shows different examples on how to use GRPC StreamObserver as a request and a response.

## How to run?

1. Run server application

```bash
cd ./server-test
gradle bootRun
cd ..
```

2. Run client application

```bash
cd ./client-test
gralde bootRun
cd ..
```

## How to use?

Make calls to the url http://localhost:8081 with one of the [API](#API) calls

## How it works?

If you make call to the next url http://localhost:8081/standard/array-list?elements=100&iterations=10, then the system will make the next steps:

1. Generate a list of 100 elements
2. Create StreamObserver for responses
3. Retrieve all responses for 10 times
4. Generate statistic of an operation

Statistic example:

```json
{
"startTime": "2021-01-12T09:52:46.180Z",
"grpcServiceExecutionDuration": 2.7072999999999996,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 2.71s",
"iterations": 10,
"chunkOperationDelay": 0,
"endTime": "2021-01-12T09:53:13.253Z"
}
```

## API

1. /standard/array-list?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside of an array list
2. /standard/linked-list?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside of an linked list
3. ~~/standard/channel?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside channel. This method use experimental feature to chunk a channel~~ - this method has problems with execution when it running with delays
4. /standard/channel-custom?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside channel. This method use self created feature to chunk a channel
5. ~~/kotlin-flow/default?elements=%n&iterations=%n TestClientKotlinFlowController.kt [GET] - This method is based on Kotlin Flow, provided by grpc-kotlin dependency. It use experimental feature to chunk a channel~~ - this method has problems with tail of an elements
6. /kotlin-flow/custom?elements=%n&iterations=%n TestClientKotlinFlowController.kt [GET] - This method is based on Kotlin Flow, provided by grpc-kotlin dependency. It use self created feature to chunk a channel

### Implementation

1. [Array List](grpc-kotlin-test/blob/master/server-test/src/main/kotlin/org/avlasov/server/grpc/TestServerGrpc.kt#L30)

## Results

Please, take a look a the [statistic response](#Statistic response) for more details

### With delay

#### 1000 Elements, 5 iterations, 1 second delay

Min execution time - 2s (1000/500*1)

1. Array list - 2.04s
2. Linked list - 2.04s
3. Channel custom - 2.05s
4. Kotlin flow custom - 2.06s

#### 5000 Elements, 5 iterations, 1 second delay

Min execution time - 10s (5000/500*1)

1. Array list - 10.18s
2. Linked list - 10.18s
3. Channel custom - 10.23s
4. Kotlin flow custom - 10.28s

#### 10000 Elements, 5 iterations, 1 second delay

Min execution time - 20s (10000/500*1)

1. Array list - 20.40s
2. Linked list - 20.40s
3. Channel custom - 20.49s
4. Kotlin flow custom - 20.55s

#### 15000 Elements, 5 iterations, 1 second delay

Min execution time - 20s (15000/500*1)

1. Array list - 30.55s
2. Linked list - 30.53s
3. Channel custom - 30.66s
4. Kotlin flow custom - 30.81s

#### 20000 Elements, 5 iterations, 1 second delay

Min execution time - 40s (20000/500*1)

1. Array list - 40.85s
2. Linked list - 40.81s
3. Channel custom - 41.04s
4. Kotlin flow custom - 40.99s

#### 50000 Elements, 5 iterations, 1 second delay

Min execution time - 100s (50000/500*1)

1. Array list - 101.77s
2. Linked list - 101.76s
3. Channel custom - 100.80s
4. Kotlin flow custom - 102.64s

#### 100000 Elements, 5 iterations, 1 second delay

Min execution time - 200s (20000/500*1)

1. Array list - 203.76s
2. Linked list - 203.68s
3. Channel custom - 203.17ss
4. Kotlin flow custom - 204.87s

### Without delay

#### 100000 Elements, 10 iterations

1. Array list - 2.71s
2. Linked list - 2.64s
3. Channel custom - 3.00s
4. Kotlin flow custom - 3.51s

#### 500000 Elements, 10 iterations

1. Array list - 12.95s
2. Linked list - 13.36s
3. Channel custom - 14.19s
4. Kotlin flow custom - 16.43s

#### 1000000 Elements, 10 iterations

1. Array list - 25.61s
2. Linked list - 28.09s
3. Channel custom - 27.71s
4. Kotlin flow custom - 29.80s

### Statistic response

```yaml
statistic-groups-result:
- group:
    elements: 20000
    iterations: 5
    chunk-delay: 1
  results:
  - url: http://localhost:8081/standard/array-list?delay=1&elements=20000&iterations=5
    result:
      start-time: "2021-01-13T09:33:16.315Z"
      grpc-service-execution-duration: 40.84779999999999
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 40.85s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T09:36:40.554Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?delay=1&elements=20000&iterations=5
    result:
      start-time: "2021-01-13T09:36:40.869Z"
      grpc-service-execution-duration: 40.8144
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 40.81s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T09:40:04.941Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?delay=1&elements=20000&iterations=5
    result:
      start-time: "2021-01-13T09:40:05.520Z"
      grpc-service-execution-duration: 41.0386
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 41.04s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T09:43:30.713Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?delay=1&elements=20000&iterations=5
    result:
      start-time: "2021-01-13T09:43:31.188Z"
      grpc-service-execution-duration: 40.9872
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 40.99s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T09:46:56.124Z"
    error: ""
- group:
    elements: 100000
    iterations: 10
    chunk-delay: 0
  results:
  - url: http://localhost:8081/standard/array-list?elements=100000&iterations=10
    result:
      start-time: "2021-01-13T09:46:56.856Z"
      grpc-service-execution-duration: 2.7138
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 2.71s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:47:23.994Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?elements=100000&iterations=10
    result:
      start-time: "2021-01-13T09:47:24.945Z"
      grpc-service-execution-duration: 2.6366
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 2.64s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:47:51.311Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?elements=100000&iterations=10
    result:
      start-time: "2021-01-13T09:47:52.022Z"
      grpc-service-execution-duration: 3.0027999999999997
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 3.00s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:48:22.050Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?elements=100000&iterations=10
    result:
      start-time: "2021-01-13T09:48:22.119Z"
      grpc-service-execution-duration: 3.5134
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 3.51s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:48:57.253Z"
    error: ""
- group:
    elements: 500000
    iterations: 10
    chunk-delay: 0
  results:
  - url: http://localhost:8081/standard/array-list?elements=500000&iterations=10
    result:
      start-time: "2021-01-13T09:48:58.265Z"
      grpc-service-execution-duration: 12.9496
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 12.95s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:51:07.761Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?elements=500000&iterations=10
    result:
      start-time: "2021-01-13T09:51:08.630Z"
      grpc-service-execution-duration: 13.3583
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 13.36s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:53:22.213Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?elements=500000&iterations=10
    result:
      start-time: "2021-01-13T09:53:22.811Z"
      grpc-service-execution-duration: 14.1934
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 14.19s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:55:44.745Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?elements=500000&iterations=10
    result:
      start-time: "2021-01-13T09:55:45.058Z"
      grpc-service-execution-duration: 16.425600000000003
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 16.43s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T09:58:29.314Z"
    error: ""
- group:
    elements: 1000000
    iterations: 10
    chunk-delay: 0
  results:
  - url: http://localhost:8081/standard/array-list?elements=1000000&iterations=10
    result:
      start-time: "2021-01-13T09:58:30.287Z"
      grpc-service-execution-duration: 25.6125
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 25.61s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T10:02:46.412Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?elements=1000000&iterations=10
    result:
      start-time: "2021-01-13T10:02:46.675Z"
      grpc-service-execution-duration: 28.089800000000004
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 28.09s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T10:07:27.573Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?elements=1000000&iterations=10
    result:
      start-time: "2021-01-13T10:07:28.061Z"
      grpc-service-execution-duration: 27.707500000000003
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 27.71s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T10:12:05.136Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?elements=1000000&iterations=10
    result:
      start-time: "2021-01-13T10:12:05.397Z"
      grpc-service-execution-duration: 29.804899999999996
      grpc-service-execution-pretty-duration: GRPC average (for 10) execution duration
        in seconds - 29.80s
      iterations: 10
      chunk-operation-delay: 0
      end-time: "2021-01-13T10:17:03.446Z"
    error: ""
- group:
    elements: 1000
    iterations: 5
    chunk-delay: 1
  results:
  - url: http://localhost:8081/standard/array-list?delay=1&elements=1000&iterations=5
    result:
      start-time: "2021-01-13T10:17:03.660Z"
      grpc-service-execution-duration: 2.044
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 2.04s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:17:13.880Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?delay=1&elements=1000&iterations=5
    result:
      start-time: "2021-01-13T10:17:14.692Z"
      grpc-service-execution-duration: 2.0436
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 2.04s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:17:24.910Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?delay=1&elements=1000&iterations=5
    result:
      start-time: "2021-01-13T10:17:25.724Z"
      grpc-service-execution-duration: 2.0522
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 2.05s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:17:35.985Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?delay=1&elements=1000&iterations=5
    result:
      start-time: "2021-01-13T10:17:36.752Z"
      grpc-service-execution-duration: 2.057
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 2.06s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:17:47.037Z"
    error: ""
- group:
    elements: 5000
    iterations: 5
    chunk-delay: 1
  results:
  - url: http://localhost:8081/standard/array-list?delay=1&elements=5000&iterations=5
    result:
      start-time: "2021-01-13T10:17:47.789Z"
      grpc-service-execution-duration: 10.183800000000002
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 10.18s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:18:38.708Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?delay=1&elements=5000&iterations=5
    result:
      start-time: "2021-01-13T10:18:38.909Z"
      grpc-service-execution-duration: 10.1828
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 10.18s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:19:29.823Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?delay=1&elements=5000&iterations=5
    result:
      start-time: "2021-01-13T10:19:30.046Z"
      grpc-service-execution-duration: 10.2268
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 10.23s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:20:21.180Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?delay=1&elements=5000&iterations=5
    result:
      start-time: "2021-01-13T10:20:21.263Z"
      grpc-service-execution-duration: 10.2822
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 10.28s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:21:12.674Z"
    error: ""
- group:
    elements: 10000
    iterations: 5
    chunk-delay: 1
  results:
  - url: http://localhost:8081/standard/array-list?delay=1&elements=10000&iterations=5
    result:
      start-time: "2021-01-13T10:21:13.569Z"
      grpc-service-execution-duration: 20.397199999999998
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 20.40s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:22:55.555Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?delay=1&elements=10000&iterations=5
    result:
      start-time: "2021-01-13T10:22:56.272Z"
      grpc-service-execution-duration: 20.4028
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 20.40s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:24:38.286Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?delay=1&elements=10000&iterations=5
    result:
      start-time: "2021-01-13T10:24:38.774Z"
      grpc-service-execution-duration: 20.492800000000003
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 20.49s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:26:21.238Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?delay=1&elements=10000&iterations=5
    result:
      start-time: "2021-01-13T10:26:21.358Z"
      grpc-service-execution-duration: 20.547800000000002
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 20.55s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:28:04.097Z"
    error: ""
- group:
    elements: 15000
    iterations: 5
    chunk-delay: 1
  results:
  - url: http://localhost:8081/standard/array-list?delay=1&elements=15000&iterations=5
    result:
      start-time: "2021-01-13T10:28:04.962Z"
      grpc-service-execution-duration: 30.5514
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 30.55s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:30:37.719Z"
    error: ""
  - url: http://localhost:8081/standard/linked-list?delay=1&elements=15000&iterations=5
    result:
      start-time: "2021-01-13T10:30:38.535Z"
      grpc-service-execution-duration: 30.525600000000004
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 30.53s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:33:11.163Z"
    error: ""
  - url: http://localhost:8081/standard/channel/custom?delay=1&elements=15000&iterations=5
    result:
      start-time: "2021-01-13T10:33:11.946Z"
      grpc-service-execution-duration: 30.6618
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 30.66s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:35:45.255Z"
    error: ""
  - url: http://localhost:8081/kotlin-flow/custom?delay=1&elements=15000&iterations=5
    result:
      start-time: "2021-01-13T10:35:45.577Z"
      grpc-service-execution-duration: 30.814600000000002
      grpc-service-execution-pretty-duration: GRPC average (for 5) execution duration
        in seconds - 30.81s
      iterations: 5
      chunk-operation-delay: 1
      end-time: "2021-01-13T10:38:19.650Z"
    error: ""

```