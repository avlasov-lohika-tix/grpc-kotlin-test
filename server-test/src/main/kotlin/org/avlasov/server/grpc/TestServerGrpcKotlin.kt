package org.avlasov.server.grpc

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flattenConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.scan
import net.devh.boot.grpc.server.service.GrpcService
import org.avlasov.grpc.TestRequest
import org.avlasov.grpc.TestResponse
import org.avlasov.grpc.TestServiceFlowGrpcKt
import org.avlasov.server.CHUNK_VALUE
import org.avlasov.server.flow.chunked
import org.avlasov.server.grpc.service.HelpService


@GrpcService
class TestServerGrpcKotlin(
    private val helpService: HelpService
) : TestServiceFlowGrpcKt.TestServiceFlowCoroutineImplBase() {

    override fun testKotlinFlow(requests: Flow<TestRequest>): Flow<TestResponse> =
        flow {
            var lastList: List<TestRequest>? = null
            requests
                .scan(listOf<TestRequest>()) { values, value ->
                    lastList = if (values.size >= CHUNK_VALUE) listOf(value)
                    else values + value
                    lastList!!
                }.filter {
                    if (it.size == CHUNK_VALUE) {
                        lastList = null
                        true
                    } else {
                        false
                    }
                }
                .map { helpService.modify(it).asFlow() }
                .collect {
                    if (lastList != null) {
                        lastList
                            .let { last -> helpService.modify(last!!) }
                            .let { last -> emitAll(last.asFlow()) }
                    }
                    emitAll(it)
                }

        }

    override fun testKotlinFlowCustom(requests: Flow<TestRequest>): Flow<TestResponse> =
        flow {
            requests.chunked(CHUNK)
                .map { helpService.modify(it) }
                .collect {
                    emitAll(it.asFlow())
                }
        }
}