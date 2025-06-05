package com.bfaydali.bookinventory.service

import com.bfaydali.bookinventory.model.entity.Book
import com.bfaydali.bookinventory.model.request.BookCreateRequest
import com.bfaydali.bookinventory.model.request.BookUpdateRequest
import org.springframework.stereotype.Service

@Service
class BookService {

    val books: MutableSet<Book> = mutableSetOf()

    fun create(request: BookCreateRequest) = books.add(request.toBook())

    fun update(id: Long, request: BookUpdateRequest) =
        findBook(id)
        .apply {
                name = request.name
                pageCount = request.pageCount
            }

    fun getAll() = books.map(Book::toBookResponse)

    fun get(id: Long) = findBook(id).toBookResponse()

    fun delete(id: Long) = books.remove(findBook(id))

    private fun findBook(id: Long) = books.find { it.id == id } ?: throw RuntimeException()
}