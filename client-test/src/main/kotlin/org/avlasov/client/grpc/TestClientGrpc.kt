package org.avlasov.client.grpc

import io.grpc.stub.StreamObserver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KLogging
import net.devh.boot.grpc.client.inject.GrpcClient
import org.avlasov.grpc.TestRequest
import org.avlasov.grpc.TestResponse
import org.avlasov.grpc.TestServiceGrpc
import org.springframework.stereotype.Component

@Component
class TestClientGrpc {

    @GrpcClient("test")
    lateinit var blockingGrpcClient: TestServiceGrpc.TestServiceBlockingStub

    @GrpcClient("test")
    lateinit var grpcClient: TestServiceGrpc.TestServiceStub

    companion object : KLogging()

    fun test(testRequest: TestRequest): TestResponse =
        blockingGrpcClient.test(testRequest)

    fun testArrayList(values: List<TestRequest>): List<TestResponse> =
        invoke(values, grpcClient::testArrayList)

    fun testLinkedList(values: List<TestRequest>): List<TestResponse> =
        invoke(values, grpcClient::testLinkedList)

    fun testChannel(values: List<TestRequest>): List<TestResponse> =
        invoke(values, grpcClient::testChannel)

    fun testChannelCustomChunked(values: List<TestRequest>): List<TestResponse> =
        invoke(values, grpcClient::testChannelChunkedCustom)

    private fun invoke(
        values: List<TestRequest>,
        operation: (StreamObserver<TestResponse>) -> StreamObserver<TestRequest>
    ): List<TestResponse> {
        val responses = Channel<TestResponse>()

        val responseObserver = object : StreamObserver<TestResponse> {
            override fun onNext(value: TestResponse?) {
                if (value == null) return

                runBlocking {
                    responses.send(value)
                }
            }

            override fun onError(t: Throwable?) {
                logger.error(t) { "Response error" }
            }

            override fun onCompleted() {
                responses.close()
            }

        }

        operation.invoke(responseObserver)
            .apply { values.forEach { onNext(it) } }
            .onCompleted()

        return runBlocking {
            responses.toList()
        }
    }

}