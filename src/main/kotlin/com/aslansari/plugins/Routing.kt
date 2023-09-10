package com.aslansari.plugins

import com.aslansari.customer.route.customerRouting
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
        customerRouting()

        get("/proxy") {
            val client = HttpClient(CIO) { }
            val resp = client.get("https://ktor.io/") { }
            val responseBody: ByteArray = resp.body()
            call.respondBytes(responseBody)
        }
    }
}
