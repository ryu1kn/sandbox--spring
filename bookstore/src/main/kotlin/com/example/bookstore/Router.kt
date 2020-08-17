package com.example.bookstore

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET

object Router {
    data class Book(val name: String)

    private val books = listOf(
        Book("Book A"),
        Book("Book B")
    )

    val route: RouterFunction<ServerResponse> = RouterFunctions.route(
        GET("/books"), HandlerFunction<ServerResponse> {
            ServerResponse.ok().body(BodyInserters.fromObject(mapOf("books" to books)))
        }
    )
}
