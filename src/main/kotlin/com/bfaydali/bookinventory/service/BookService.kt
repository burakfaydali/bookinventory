package com.bfaydali.bookinventory.service

import com.bfaydali.bookinventory.model.entity.Book
import com.bfaydali.bookinventory.model.errors.DomainNotFoundException
import com.bfaydali.bookinventory.model.request.book.BookCreateRequest
import com.bfaydali.bookinventory.model.request.book.BookUpdateRequest
import com.bfaydali.bookinventory.model.response.BookResponse
import com.bfaydali.bookinventory.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val authorService: AuthorService,
) {

    fun create(request: BookCreateRequest): BookResponse {
        val author = authorService.findAuthor(request.authorId)
        return bookRepository.save(request.toBook(author)).toResponse()
    }

    fun update(id: Long, request: BookUpdateRequest): BookResponse {
        val book = findBook(id)
            .apply {
                name = request.name
                pageCount = request.pageCount
                categories = request.categories
            }
        return bookRepository.save(book).toResponse()
    }

    fun getAll() = bookRepository.findAll().map(Book::toResponse)

    fun get(id: Long) = findBook(id).toResponse()

    fun delete(id: Long) = bookRepository.deleteById(id)

    private fun findBook(id: Long) = bookRepository
        .findById(id)
        .orElseThrow { DomainNotFoundException("book.not.found") }
}