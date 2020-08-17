package com.example.bookstore

import io.undertow.Undertow
import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.server.reactive.UndertowHttpHandlerAdapter
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.server.WebHandler
import org.springframework.web.server.adapter.WebHttpHandlerBuilder.WEB_HANDLER_BEAN_NAME
import org.springframework.web.server.adapter.WebHttpHandlerBuilder.applicationContext
import java.util.function.Supplier

fun main(args: Array<String>) {
    val context = GenericApplicationContext().apply {
        registerBean(WEB_HANDLER_BEAN_NAME, WebHandler::class.java, Supplier {
            RouterFunctions.toWebHandler(Router.route)
        })
        refresh()
    }

    val handler = applicationContext(context).build()
    val server = Undertow.builder()
        .setHandler(UndertowHttpHandlerAdapter(handler))
        .addHttpListener(8080, "0.0.0.0")
        .build()
    server.start()
}
