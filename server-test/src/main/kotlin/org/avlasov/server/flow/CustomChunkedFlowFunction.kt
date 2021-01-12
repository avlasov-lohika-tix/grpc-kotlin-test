package org.avlasov.server.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.avlasov.server.grpc.CHUNK
import java.util.*

//fun <T> Flow<T>.chunked(chunk: Int): Flow<List<T>> = flow {
//    val buffer = ArrayDeque<T>()
//    collect { value ->
//        buffer.addLast(value)
//
//        if (buffer.size == chunk) {
//            emit(buffer.toList())
//            repeat(chunk) {
//                buffer.removeFirst()
//            }
//        }
//
//    }
//
//    while (buffer.isNotEmpty()) {
//        emit(buffer.toList())
//        repeat(buffer.size) {
//            buffer.removeFirst()
//        }
//    }
//}

fun <T> Flow<T>.chunked(bufferSize: Int): Flow<List<T>> = flow {
    val buffer = Collections.synchronizedList(mutableListOf<T>())
    collect { value ->
        buffer += value
        if (buffer.size >= bufferSize) {
            val subList = buffer.subList(0, bufferSize)
            emit(subList)
            (0..bufferSize).forEach { buffer.removeAt(it) }
        }
    }

    while (buffer.isNotEmpty()) {
        emit(buffer)
        buffer.clear()
    }
}