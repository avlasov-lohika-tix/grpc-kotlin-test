package org.avlasov.server.grpc.service

import org.avlasov.grpc.TestRequest
import org.avlasov.grpc.TestResponse
import org.springframework.stereotype.Service
import java.lang.Thread.sleep
import java.time.Duration
import java.time.temporal.ChronoUnit

@Service
class HelpService {

    fun modify(testRequests: List<TestRequest>): List<TestResponse> =
        testRequests
            .takeIf {
                val delay = testRequests.first().delay
                if (delay > 0) {
                    sleep(Duration.ofSeconds(delay.toLong()).toMillis())
                }
                true
            }!!
            .map {
                TestResponse
                    .newBuilder()
                    .setOriginalValue(it.value)
                    .setNewValue(it.value * 2)
                    .build()
            }

}