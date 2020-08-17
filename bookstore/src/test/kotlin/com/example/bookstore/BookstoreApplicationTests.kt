package com.example.bookstore

import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

class BookstoreApplicationTests {

    @Test
    fun `Retrieve all books`() {
        val testClient = WebTestClient.bindToRouterFunction(Router.route).build()
        testClient.get().uri("/books")
            .exchange()
            .expectStatus().isOk()
            .expectBody<Map<String,List<String>>>()
            .isEqualTo(mapOf("books" to listOf("Book A", "Book B")))
    }
}
