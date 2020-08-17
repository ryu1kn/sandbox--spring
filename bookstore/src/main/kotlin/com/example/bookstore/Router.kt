package com.example.bookstore

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET

class Router(private val bookRepo: BookRepo, private val authorRepo: AuthorRepo) {
    val route: RouterFunction<ServerResponse> = RouterFunctions.route(
        GET("/books"), HandlerFunction<ServerResponse> {
            ServerResponse.ok().body(BodyInserters.fromObject(
                mapOf("books" to bookRepo.list().map {
                    mapOf(
                        "name" to it.name,
                        "author" to authorRepo.resolveName(it.authorId)
                    )
                })
            ))
        }
    )
}
