package org.avlasov.server

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.avlasov.server.flow.chunked
import java.util.concurrent.TimeUnit


const val CHUNK_VALUE = 10

//fun main() {
//    val channel = Channel<Int>()
//
//    consume(channel)
//
//    customConsume(channel)
//
//    GlobalScope.launch {
//        for (i in 1..1000001) {
//            channel.send(i)
//        }
//        channel.close()
//    }
//
//    runBlocking {
//        delay(100000L)
//    }
//}

fun consume(channel: Channel<Int>) = GlobalScope.launch {
    val start = System.currentTimeMillis()
    channel.consumeAsFlow()
        .scan(listOf<Int>()) { values, value ->
            if (values.size >= CHUNK_VALUE) listOf(value)
            else values + value
        }
//        .filter { it.size == CHUNK_VALUE }
        .collect {
            println(it)
        }
    println("Completed in ${TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start)}")
}

fun customConsume(channel: Channel<Int>) = GlobalScope.launch {
    val start = System.currentTimeMillis()
    channel.consumeAsFlow()
        .chunked(CHUNK_VALUE)
        .collect { println(it) }
    println("Completed in ${TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start)}")
}

