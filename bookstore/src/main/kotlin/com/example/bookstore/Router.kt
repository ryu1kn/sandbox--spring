package com.example.bookstore

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET

object Router {
    private val books = listOf(
        mapOf("name" to "Book A"),
        mapOf("name" to "Book B")
    )

    val route: RouterFunction<ServerResponse> = RouterFunctions.route(
        GET("/books"), HandlerFunction<ServerResponse> {
            ServerResponse.ok().body(BodyInserters.fromObject(mapOf("books" to books)))
        }
    )
}