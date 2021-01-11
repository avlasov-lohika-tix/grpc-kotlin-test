package org.avlasov.client.grpc

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import mu.KLogging
import net.devh.boot.grpc.client.inject.GrpcClient
import org.avlasov.grpc.TestRequest
import org.avlasov.grpc.TestResponse
import org.avlasov.grpc.TestServiceFlowGrpcKt
import org.springframework.stereotype.Component

@Component
class TestClientKotlinFlowGrpc {

    @GrpcClient("test")
    lateinit var grpcClient: TestServiceFlowGrpcKt.TestServiceFlowCoroutineStub

    companion object : KLogging()

    fun testKotlinFlow(request: List<TestRequest>): List<TestResponse> = runBlocking {
        grpcClient.testKotlinFlow(request.asFlow())
            .toList()
    }

    fun testKotlinFlowCustom(request: List<TestRequest>): List<TestResponse> = runBlocking {
        grpcClient.testKotlinFlowCustom(request.asFlow())
            .toList()
    }

}
