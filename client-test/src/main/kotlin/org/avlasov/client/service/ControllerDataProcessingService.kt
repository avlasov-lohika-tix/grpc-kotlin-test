package org.avlasov.client.service

import org.avlasov.client.controller.model.DataResponseDto
import org.avlasov.grpc.TestRequest
import org.avlasov.grpc.TestResponse
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Duration
import java.time.Instant

@Service
class ControllerDataProcessingService {

    fun process(
        elements: Long,
        iterations: Int = 1,
        operation: (requests: List<TestRequest>) -> List<TestResponse>
    ): DataResponseDto {
        val requests = (1L..elements)
            .map { TestRequest.newBuilder().setValue(it).build() }

        val start = Instant.now()

        val averageExecutionTime = (0 until iterations)
            .map {
                val grpcProcessStartTime = Instant.now()

                val result = operation.invoke(requests)

                if (result.size.compareTo(elements) != 0) {
                    throw RuntimeException("Number of processed elements is not matching with requested number")
                }

                Duration.between(grpcProcessStartTime, Instant.now())
                    .let { BigDecimal.valueOf(it.seconds).add(BigDecimal.valueOf(it.nano.toLong(), 9)); }
                    .toDouble()
            }.average()

        return DataResponseDto(
            startTime = start,
            endTime = Instant.now(),
            grpcServiceExecutionDuration = averageExecutionTime,
            grpcServiceExecutionPrettyDuration = "GRPC average (for $iterations) execution duration in seconds - ${averageExecutionTime.let { String.format("%.2f", it) }}s",
            iterations = iterations
        )

    }

}