package org.avlasov.client.controller.model

import org.avlasov.grpc.TestResponse

data class TestResponseDto(
    val originalValue: Long,
    val newValue: Long
)

fun TestResponse.toTestResponseDto() =
    TestResponseDto(this.originalValue, this.newValue)
