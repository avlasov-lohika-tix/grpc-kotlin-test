package org.avlasov.client

import java.math.BigDecimal
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit

fun main() {
    val between = Duration.between(Instant.now(), Instant.now().plusSeconds(30).plusNanos(10))

    println(between.seconds)
    println(between.nano)
    println(between
        .let { BigDecimal.valueOf(it.seconds).add(BigDecimal.valueOf(it.nano.toLong(), 2)); }
        .toDouble())
}