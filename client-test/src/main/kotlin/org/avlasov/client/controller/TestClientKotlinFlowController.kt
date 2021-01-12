package org.avlasov.client.controller

import org.avlasov.client.controller.model.DataResponseDto
import org.avlasov.client.grpc.TestClientKotlinFlowGrpc
import org.avlasov.client.service.ControllerDataProcessingService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/kotlin-flow")
class TestClientKotlinFlowController(
    private val testClientKotlinFlowGrpc: TestClientKotlinFlowGrpc,
    private val controllerDataProcessingService: ControllerDataProcessingService
) {

    @GetMapping("/default")
    fun testKotlinFlow(
        @RequestParam elements: Long,
        @RequestParam(required = false, defaultValue = "1") iterations: Int,
        @RequestParam(required = false, defaultValue = "0") delay: Short
    ): ResponseEntity<DataResponseDto> =
        ResponseEntity.ok(controllerDataProcessingService.process(elements, iterations, delay, testClientKotlinFlowGrpc::testKotlinFlow))

    @GetMapping("/custom")
    fun testKotlinFlowCustom(
        @RequestParam elements: Long,
        @RequestParam(required = false, defaultValue = "1") iterations: Int,
        @RequestParam(required = false, defaultValue = "0") delay: Short
    ): ResponseEntity<DataResponseDto> =
        ResponseEntity.ok(controllerDataProcessingService.process(elements, iterations, delay, testClientKotlinFlowGrpc::testKotlinFlowCustom))


}