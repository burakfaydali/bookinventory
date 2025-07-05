package com.bfaydali.bookinventory.controller

import com.bfaydali.bookinventory.model.request.AuthorFilterRequest
import com.bfaydali.bookinventory.model.request.author.AuthorCreateRequest
import com.bfaydali.bookinventory.model.request.author.AuthorUpdateRequest
import com.bfaydali.bookinventory.model.response.AuthorResponse
import com.bfaydali.bookinventory.model.response.PageableResponse
import com.bfaydali.bookinventory.service.AuthorService
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authors")
class AuthorController(
    private val authorService: AuthorService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: AuthorCreateRequest): AuthorResponse = authorService.create(request)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: AuthorUpdateRequest): AuthorResponse =
        authorService.update(id, request)

    @GetMapping
    fun getAll(@ParameterObject request: AuthorFilterRequest): PageableResponse<AuthorResponse> =
        authorService.getAll(request)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): AuthorResponse = authorService.get(id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = authorService.delete(id)
} 