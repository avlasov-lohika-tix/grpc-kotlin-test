package org.avlasov.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
