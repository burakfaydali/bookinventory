package com.bfaydali.bookinventory.controller

import com.bfaydali.bookinventory.model.request.AuthorCreateRequest
import com.bfaydali.bookinventory.model.request.AuthorUpdateRequest
import com.bfaydali.bookinventory.model.response.AuthorResponse
import com.bfaydali.bookinventory.service.AuthorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authors")
class AuthorController(
    private val authorService: AuthorService
) {

    @PostMapping
    fun create(@RequestBody request: AuthorCreateRequest): AuthorResponse = authorService.create(request)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: AuthorUpdateRequest): AuthorResponse = authorService.update(id, request)

    @GetMapping
    fun getAll(): List<AuthorResponse> = authorService.getAll()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): AuthorResponse = authorService.get(id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = authorService.delete(id)
} 