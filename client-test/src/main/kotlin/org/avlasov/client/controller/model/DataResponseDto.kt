package org.avlasov.client.controller.model

import java.time.Duration
import java.time.Instant

data class DataResponseDto(
    val startTime: Instant,
    val grpcServiceExecutionDuration: Double,
    val grpcServiceExecutionPrettyDuration: String,
    val iterations: Int,
    val endTime: Instant
)
