package org.avlasov.client.controller

import org.avlasov.client.controller.model.DataResponseDto
import org.avlasov.client.controller.model.TestResponseDto
import org.avlasov.client.controller.model.toTestResponseDto
import org.avlasov.client.grpc.TestClientGrpc
import org.avlasov.client.service.ControllerDataProcessingService
import org.avlasov.grpc.TestRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/standard")
class TestClientStandardController(
    private val testClientGrpc: TestClientGrpc,
    private val controllerDataProcessingService: ControllerDataProcessingService
) {

    @GetMapping("/test")
    fun test(@RequestParam value: Long): ResponseEntity<TestResponseDto> =
        testClientGrpc.test(TestRequest.newBuilder().setValue(value).build())
            .toTestResponseDto()
            .let { ResponseEntity.ok(it) }

    @GetMapping("/array-list")
    fun testArrayList(
        @RequestParam elements: Long,
        @RequestParam(required = false, defaultValue = "1") iterations: Int,
        @RequestParam(required = false, defaultValue = "0") delay: Short
    ): ResponseEntity<DataResponseDto> =
        ResponseEntity.ok(controllerDataProcessingService.process(elements, iterations, delay, testClientGrpc::testArrayList))

    @GetMapping("/linked-list")
    fun testLinkedList(
        @RequestParam elements: Long,
        @RequestParam(required = false, defaultValue = "1") iterations: Int,
        @RequestParam(required = false, defaultValue = "0") delay: Short
    ): ResponseEntity<DataResponseDto> =
        ResponseEntity.ok(controllerDataProcessingService.process(elements, iterations, delay, testClientGrpc::testLinkedList))

    @GetMapping("/channel")
    fun testChannel(
        @RequestParam elements: Long,
        @RequestParam(required = false, defaultValue = "1") iterations: Int,
        @RequestParam(required = false, defaultValue = "0") delay: Short
    ): ResponseEntity<DataResponseDto> =
        ResponseEntity.ok(controllerDataProcessingService.process(elements, iterations, delay, testClientGrpc::testChannel))

    @GetMapping("/channel/custom")
    fun testChannelCustomChunked(
        @RequestParam elements: Long,
        @RequestParam(required = false, defaultValue = "1") iterations: Int,
        @RequestParam(required = false, defaultValue = "0") delay: Short
    ): ResponseEntity<DataResponseDto> =
        ResponseEntity.ok(controllerDataProcessingService.process(elements, iterations, delay, testClientGrpc::testChannelCustomChunked))

}