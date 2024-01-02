package com.xuspi.libraryapp.repository

import com.xuspi.libraryapp.room.BookEntity
import com.xuspi.libraryapp.room.BooksDB

class Repository(val booksDB: BooksDB) {

    suspend fun addBookToRoom(bookEntity: BookEntity) {
        booksDB.bookDao().addBook(bookEntity)
    }

    fun getAllBooks() = booksDB.bookDao().getAllBooks()

    suspend fun deleteBookFromRoom(bookEntity: BookEntity) {
        booksDB.bookDao().deleteBook(bookEntity)
    }

    suspend fun updateBookFromRoom(bookEntity: BookEntity) {
        booksDB.bookDao().updateBook(bookEntity)
    }
}