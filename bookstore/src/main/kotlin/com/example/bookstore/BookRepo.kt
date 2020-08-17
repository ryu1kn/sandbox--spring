package com.example.bookstore

class BookRepo {
    data class Book(val name: String)

    fun list(): List<Book> = listOf(
        Book("Book A"),
        Book("Book B")
    )
}
