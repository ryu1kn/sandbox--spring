package com.example.bookstore

interface BookRepo {
    fun list(): List<Book>
}

class RealBookRepo : BookRepo {
    override fun list(): List<Book> = listOf(
        Book("Book A"),
        Book("Book B")
    )
}

data class Book(val name: String)
