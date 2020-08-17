package com.example.bookstore

import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

typealias BookInfo = Map<String, String>

class BookstoreApplicationTests {

    @Test
    fun `Retrieve all books`() {
        val testClient = WebTestClient.bindToRouterFunction(Router.route).build()
        testClient.get().uri("/books")
            .exchange()
            .expectStatus().isOk()
            .expectBody<Map<String,List<BookInfo>>>()
            .isEqualTo(mapOf("books" to listOf(
                mapOf("name" to "Book A"),
                mapOf("name" to "Book B")
            )))
    }
}
