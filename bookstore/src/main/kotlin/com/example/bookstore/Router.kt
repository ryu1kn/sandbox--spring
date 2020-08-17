package com.example.bookstore

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET

class Router(private val bookRepo: BookRepo) {
    val route: RouterFunction<ServerResponse> = RouterFunctions.route(
        GET("/books"), HandlerFunction<ServerResponse> {
            ServerResponse.ok().body(BodyInserters.fromObject(mapOf("books" to bookRepo.list())))
        }
    )
}
