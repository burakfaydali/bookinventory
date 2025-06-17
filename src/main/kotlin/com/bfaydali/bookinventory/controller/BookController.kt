package com.bfaydali.bookinventory.controller

import com.bfaydali.bookinventory.model.request.book.BookCreateRequest
import com.bfaydali.bookinventory.model.request.book.BookUpdateRequest
import com.bfaydali.bookinventory.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    val bookService: BookService
) {

    @PostMapping
    fun create(@RequestBody request: BookCreateRequest) = bookService.create(request)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: BookUpdateRequest
    ) = bookService.update(id, request)

    @GetMapping
    fun getAll() = bookService.getAll()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = bookService.get(id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = bookService.delete(id)
}