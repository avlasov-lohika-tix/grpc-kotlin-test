package org.avlasov.server.grpc

import io.grpc.stub.StreamObserver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flattenConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.devh.boot.grpc.server.service.GrpcService
import org.avlasov.grpc.TestRequest
import org.avlasov.grpc.TestResponse
import org.avlasov.grpc.TestServiceGrpc
import org.avlasov.server.CHUNK_VALUE
import org.avlasov.server.flow.chunked
import org.avlasov.server.grpc.service.HelpService
import java.util.*

@GrpcService
class TestServerGrpc(
    private val helpService: HelpService
) : TestServiceGrpc.TestServiceImplBase() {

    override fun testArrayList(responseObserver: StreamObserver<TestResponse>): StreamObserver<TestRequest> =
        object : StreamObserver<TestRequest> {

            var values = Collections.synchronizedList(mutableListOf<TestRequest>())

            override fun onNext(value: TestRequest?) {
                if (value == null) return

                values.add(value)

                val currentSize = values.size

                if (currentSize != 0 && currentSize % CHUNK == 0) {
                    val subList = values.subList(0, CHUNK)
                    helpService.modify(subList)
                        .forEach { responseObserver.onNext(it) }
                    repeat(CHUNK) { values.removeFirst() }
                }
            }

            override fun onError(t: Throwable?) {
                responseObserver.onError(t)
                values.clear()
            }

            override fun onCompleted() {
                val size = values.size
                if (size != 0 && size % CHUNK != 0) {
                    val lastValues = size % CHUNK
                    values.subList(size - lastValues, size)
                        .let { helpService.modify(it) }
                        .forEach { responseObserver.onNext(it) }
                }
                responseObserver.onCompleted()
                values.clear()
            }

        }

    override fun testLinkedList(responseObserver: StreamObserver<TestResponse>?): StreamObserver<TestRequest> =
        object : StreamObserver<TestRequest> {

            val values = LinkedList<TestRequest>()

            override fun onNext(value: TestRequest?) {
                if (responseObserver == null || value == null) return

                values.add(value)

                val currentSize = values.size

                if (currentSize >= CHUNK) {
                    (0..CHUNK)
                        .mapNotNull { values.poll() }
                        .let { helpService.modify(it) }
                        .forEach { responseObserver.onNext(it) }
                }
            }

            override fun onError(t: Throwable?) {
                responseObserver?.onError(t)
            }

            override fun onCompleted() {
                if (responseObserver != null && values.isNotEmpty()) {
                    values
                        .let { helpService.modify(it) }
                        .forEach { responseObserver.onNext(it) }
                }
                responseObserver?.onCompleted()
            }

        }

    override fun testChannel(responseObserver: StreamObserver<TestResponse>?): StreamObserver<TestRequest> =
        object : StreamObserver<TestRequest> {

            val values = Channel<TestRequest>()
            val request = GlobalScope.launch {
                var lastList: List<TestRequest>? = null
                values.receiveAsFlow()
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
                    .flattenConcat()
                    .collect { response -> responseObserver?.onNext(response) }
                if (lastList != null) {
                    lastList
                        .let { helpService.modify(it!!) }
                        .forEach { responseObserver?.onNext(it) }
                }
            }

            override fun onNext(value: TestRequest?) {
                if (responseObserver == null || value == null) return

                send(value)
            }

            override fun onError(t: Throwable?) {
                responseObserver?.onError(t)
            }

            override fun onCompleted() {
                runBlocking {
                    values.close()
                    request.join()
                    responseObserver?.onCompleted()
                }
            }

            private fun send(testRequest: TestRequest) {
                runBlocking {
                    values.send(testRequest)
                }
            }

        }

    override fun testChannelChunkedCustom(responseObserver: StreamObserver<TestResponse>): StreamObserver<TestRequest> =
        object : StreamObserver<TestRequest> {

            val values = Channel<TestRequest>()
            val request = GlobalScope.launch {
                values.receiveAsFlow()
                    .chunked(CHUNK)
                    .flatMapConcat { helpService.modify(it).asFlow() }
                    .collect {
                        responseObserver.onNext(it)
                    }
            }

            override fun onNext(value: TestRequest?) {
                if (value == null) return

                GlobalScope.launch {
                    values.send(value)
                }
            }

            override fun onError(t: Throwable?) {
                responseObserver.onError(t)
            }

            override fun onCompleted() {
                GlobalScope.launch {
                    values.close()
                    request.join()
                    responseObserver.onCompleted()
                }
            }

        }

    override fun test(request: TestRequest?, responseObserver: StreamObserver<TestResponse>?) {
        if (request == null || responseObserver == null) return

        helpService.modify(listOf(request))
            .first()
            .let { responseObserver.onNext(it) }

        responseObserver.onCompleted()
    }
}