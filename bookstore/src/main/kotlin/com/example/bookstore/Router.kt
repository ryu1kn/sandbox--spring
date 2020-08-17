package com.example.bookstore

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*

object Router {
    val helloWorldRoute: RouterFunction<ServerResponse> = RouterFunctions.route(
        RequestPredicates.path("/hello-world"),
        HandlerFunction<ServerResponse> { ServerResponse.ok().body(BodyInserters.fromObject("Hello World")) }
    )
}
