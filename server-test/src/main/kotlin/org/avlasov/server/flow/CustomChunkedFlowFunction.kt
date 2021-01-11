package org.avlasov.server.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.chunked(chunk: Int): Flow<List<T>> = flow {
    val buffer = ArrayDeque<T>()
    collect { value ->
        buffer.addLast(value)

        if (buffer.size == chunk) {
            emit(buffer.toList())
            repeat(chunk) {
                buffer.removeFirst()
            }
        }

    }

    while (buffer.isNotEmpty()) {
        emit(buffer.toList())
        repeat(buffer.size) {
            buffer.removeFirst()
        }
    }
}