package com.bfaydali.bookinventory.service

import com.bfaydali.bookinventory.model.entity.Book
import com.bfaydali.bookinventory.model.request.BookCreateRequest
import com.bfaydali.bookinventory.model.request.BookUpdateRequest
import com.bfaydali.bookinventory.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository,
) {

    fun create(request: BookCreateRequest) = bookRepository.save(request.toBook())

    fun update(id: Long, request: BookUpdateRequest) {
        val book = findBook(id)
            .apply {
                name = request.name
                pageCount = request.pageCount
            }
        bookRepository.save(book)
    }

    fun getAll() = bookRepository.findAll().map(Book::toBookResponse)

    fun get(id: Long) = findBook(id).toBookResponse()

    fun delete(id: Long) = bookRepository.deleteById(id)

    private fun findBook(id: Long) = bookRepository
        .findById(id)
        .orElseThrow { RuntimeException() }
}