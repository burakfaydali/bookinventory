package com.bfaydali.bookinventory.controller

import com.bfaydali.bookinventory.model.request.BookCreateRequest
import com.bfaydali.bookinventory.model.request.BookUpdateRequest
import com.bfaydali.bookinventory.service.BookService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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