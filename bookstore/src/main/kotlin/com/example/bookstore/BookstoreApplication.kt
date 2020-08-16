package com.example.bookstore

import io.undertow.Undertow
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.http.server.reactive.UndertowHttpHandlerAdapter
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.server.WebHandler
import org.springframework.web.server.adapter.WebHttpHandlerBuilder.WEB_HANDLER_BEAN_NAME
import org.springframework.web.server.adapter.WebHttpHandlerBuilder.applicationContext
import java.util.function.Supplier

fun main(args: Array<String>) {
    val helloWorldRoute = RouterFunctions.route(
            RequestPredicates.path("/hello-world"),
            HandlerFunction<ServerResponse> { ServerResponse.ok().body(fromObject("Hello World")) }
    )

    val context = AnnotationConfigApplicationContext().apply {
        registerBean(WEB_HANDLER_BEAN_NAME, WebHandler::class.java, Supplier { RouterFunctions.toWebHandler(helloWorldRoute) })
        refresh()
    }

    val handler = applicationContext(context).build()
    val server = Undertow.builder()
        .setHandler(UndertowHttpHandlerAdapter(handler))
        .addHttpListener(8080, "0.0.0.0")
        .build()
    server.start()
}
