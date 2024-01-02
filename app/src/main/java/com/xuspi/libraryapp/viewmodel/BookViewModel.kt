package com.xuspi.libraryapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xuspi.libraryapp.repository.Repository
import com.xuspi.libraryapp.room.BookEntity
import kotlinx.coroutines.launch

class BookViewModel(val repository: Repository): ViewModel() {

    fun addBook(book: BookEntity) {
        viewModelScope.launch {
            repository.addBookToRoom(book)
        }
    }

    val books = repository.getAllBooks()

    fun deleteBook(book: BookEntity) {
        viewModelScope.launch {
            repository.deleteBookFromRoom(book)
        }
    }

    fun updateBook(book: BookEntity) {
        viewModelScope.launch {
            repository.updateBookFromRoom(book)
        }
    }
}