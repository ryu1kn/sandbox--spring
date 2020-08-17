package com.example.bookstore

import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

class BookstoreApplicationTests {

    @Test
    fun test() {
        val testClient = WebTestClient.bindToRouterFunction(Router.helloWorldRoute).build()
        testClient.get().uri("/hello-world")
            .exchange()
            .expectStatus().isOk()
            .expectBody<String>().isEqualTo("Hello World")
    }
}
