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
"startTime": "2021-01-11T16:03:40.588Z",
"grpcServiceExecutionDuration": 2.2720999999999996,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 2.27s",
"iterations": 10,
"endTime": "2021-01-11T16:04:03.309Z"
}
```

## API

1. /standard/array-list?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside of an array list
2. /standard/linked-list?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside of an linked list
3. /standard/channel?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside channel. This method use experimental feature to chunk a channel
4. /standard/channel-custom?elements=%n&iterations=%n TestClientStandardController.kt [GET] - all elements are stored inside channel. This method use self created feature to chunk a channel
5. ~~/kotlin-flow/default?elements=%n&iterations=%n TestClientKotlinFlowController.kt [GET] - This method is based on Kotlin Flow, provided by grpc-kotlin dependency. It use experimental feature to chunk a channel~~ - this method has problems with tail of an elements
6. /kotlin-flow/custom?elements=%n&iterations=%n TestClientKotlinFlowController.kt [GET] - This method is based on Kotlin Flow, provided by grpc-kotlin dependency. It use self created feature to chunk a channel

## Results

### 100000 Elements for 10 iterations

1. Array list - 2.27s
2. Linked list - 2.27s
3. Channel - 3.14s
4. Channel custom - 2.62s
5. Kotlin flow - 3.21s
6. Kotlin flow custom - 2.77s

### 500000 Elements for 10 iterations

1. Array list - 12.25s
2. Linked list - 12.86s
3. Channel - 15.95s
4. Channel custom - 14.14s
5. Kotlin flow - 16.64s
6. Kotlin flow custom - 15.75s

### 1M Elements for 10 iterations

1. Array list - 24.89s
2. Linked list - 24.45s
3. Channel - 30.66s
4. Channel custom - 27.51s
5. Kotlin flow - 33.70s
6. Kotlin flow custom - 29.54s

### 5M Elements

### Responses

#### Array list

http://localhost:8081/standard/array-list?elements=100000&iterations=10

```json
{
"startTime": "2021-01-11T16:03:40.588Z",
"grpcServiceExecutionDuration": 2.2720999999999996,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 2.27s",
"iterations": 10,
"endTime": "2021-01-11T16:04:03.309Z"
}
```

http://localhost:8081/standard/array-list?elements=500000&iterations=10

```json
{
"startTime": "2021-01-11T16:04:49.207Z",
"grpcServiceExecutionDuration": 12.2513,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 12.25s",
"iterations": 10,
"endTime": "2021-01-11T16:06:51.720Z"
}
```

http://localhost:8081/standard/array-list?elements=1000000&iterations=10

```json
{
"startTime": "2021-01-11T16:07:41.246Z",
"grpcServiceExecutionDuration": 24.8851,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 24.89s",
"iterations": 10,
"endTime": "2021-01-11T16:11:50.099Z"
}
```

#### Linked List

http://localhost:8081/standard/linked-list?elements=100000&iterations=10

```json
{
"startTime": "2021-01-11T16:12:25.017Z",
"grpcServiceExecutionDuration": 2.2667,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 2.27s",
"iterations": 10,
"endTime": "2021-01-11T16:12:47.684Z"
}
```

http://localhost:8081/standard/linked-list?elements=500000&iterations=10

```json
{
"startTime": "2021-01-11T16:13:01.908Z",
"grpcServiceExecutionDuration": 12.864800000000002,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 12.86s",
"iterations": 10,
"endTime": "2021-01-11T16:15:10.556Z"
}
```

http://localhost:8081/standard/linked-list?elements=1000000&iterations=10

```json
{
"startTime": "2021-01-11T16:16:47.350Z",
"grpcServiceExecutionDuration": 24.446500000000004,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 24.45s",
"iterations": 10,
"endTime": "2021-01-11T16:20:51.815Z"
}
```

#### Channel

http://localhost:8081/standard/channel?elements=100000&iterations=10

```json
{
"startTime": "2021-01-11T16:22:33.738Z",
"grpcServiceExecutionDuration": 3.1417,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 3.14s",
"iterations": 10,
"endTime": "2021-01-11T16:23:05.155Z"
}
```

http://localhost:8081/standard/channel?elements=500000&iterations=10

```json
{
"startTime": "2021-01-11T16:24:03.146Z",
"grpcServiceExecutionDuration": 15.951799999999997,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 15.95s",
"iterations": 10,
"endTime": "2021-01-11T16:26:42.665Z"
}
```

http://localhost:8081/standard/channel?elements=1000000&iterations=10

```json
{
"startTime": "2021-01-11T16:27:18.663Z",
"grpcServiceExecutionDuration": 30.656600000000005,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 30.66s",
"iterations": 10,
"endTime": "2021-01-11T16:32:25.229Z"
}
```

#### Channel with custom chunking

http://localhost:8081/standard/channel/custom?elements=100000&iterations=10

```json
{
"startTime": "2021-01-11T16:33:09.325Z",
"grpcServiceExecutionDuration": 2.6186,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 2.62s",
"iterations": 10,
"endTime": "2021-01-11T16:33:35.512Z"
}
```

http://localhost:8081/standard/channel/custom?elements=500000&iterations=10

```json
{
"startTime": "2021-01-11T16:33:39.643Z",
"grpcServiceExecutionDuration": 14.143099999999999,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 14.14s",
"iterations": 10,
"endTime": "2021-01-11T16:36:01.075Z"
}
```

http://localhost:8081/standard/channel/custom?elements=1000000&iterations=10

```json
{
"startTime": "2021-01-11T16:36:39.809Z",
"grpcServiceExecutionDuration": 27.5137,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 27.51s",
"iterations": 10,
"endTime": "2021-01-11T16:41:14.947Z"
}
```

#### Flow

http://localhost:8081/kotlin-flow/default?elements=100000&iterations=10

```json
{
"startTime": "2021-01-11T16:44:13.108Z",
"grpcServiceExecutionDuration": 3.2086999999999994,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 3.21s",
"iterations": 10,
"endTime": "2021-01-11T16:44:45.195Z"
}
```

http://localhost:8081/kotlin-flow/default?elements=500000&iterations=10

```json
{
"startTime": "2021-01-11T16:47:06.858Z",
"grpcServiceExecutionDuration": 16.6394,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 16.64s",
"iterations": 10,
"endTime": "2021-01-11T16:49:53.252Z"
}
```

http://localhost:8081/kotlin-flow/default?elements=1000000&iterations=10

```json
{
"startTime": "2021-01-11T16:50:08.082Z",
"grpcServiceExecutionDuration": 33.7016,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 33.70s",
"iterations": 10,
"endTime": "2021-01-11T16:55:45.099Z"
}
```

#### Flow Custom

http://localhost:8081/kotlin-flow/custom?elements=100000&iterations=10

```json
{
"startTime": "2021-01-11T17:15:49.645Z",
"grpcServiceExecutionDuration": 2.7677,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 2.77s",
"iterations": 10,
"endTime": "2021-01-11T17:16:17.322Z"
}
```

http://localhost:8081/kotlin-flow/custom?elements=500000&iterations=10

```json
{
"startTime": "2021-01-11T17:18:27.768Z",
"grpcServiceExecutionDuration": 15.749100000000002,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 15.75s",
"iterations": 10,
"endTime": "2021-01-11T17:21:05.259Z"
}
```

http://localhost:8081/kotlin-flow/custom?elements=1000000&iterations=10

```json
{
"startTime": "2021-01-11T17:25:24.419Z",
"grpcServiceExecutionDuration": 29.540200000000006,
"grpcServiceExecutionPrettyDuration": "GRPC average (for 10) execution duration in seconds - 29.54s",
"iterations": 10,
"endTime": "2021-01-11T17:30:19.821Z"
}
```

#### 