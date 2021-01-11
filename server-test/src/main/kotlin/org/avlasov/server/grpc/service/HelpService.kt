package org.avlasov.server.grpc.service

import org.avlasov.grpc.TestRequest
import org.avlasov.grpc.TestResponse
import org.springframework.stereotype.Service

@Service
class HelpService {

    fun modify(testRequest: TestRequest): TestResponse =
        testRequest
            .let {
                TestResponse
                    .newBuilder()
                    .setOriginalValue(it.value)
                    .setNewValue(it.value * 2)
                    .build()
            }

    fun modify(testRequests: List<TestRequest>): List<TestResponse> =
        testRequests
            .map {
                TestResponse
                    .newBuilder()
                    .setOriginalValue(it.value)
                    .setNewValue(it.value * 2)
                    .build()
            }

}