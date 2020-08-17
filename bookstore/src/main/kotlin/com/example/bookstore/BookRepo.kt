package com.example.bookstore

interface BookRepo {
    fun list(): List<Book>
}

class RealBookRepo : BookRepo {
    private val booksLoadedFromDB = listOf(
        Book("Book A", "author-a"),
        Book("Book B", "author-b")
    )

    override fun list(): List<Book> = booksLoadedFromDB
}

data class Book(val name: String, val authorId: String)
