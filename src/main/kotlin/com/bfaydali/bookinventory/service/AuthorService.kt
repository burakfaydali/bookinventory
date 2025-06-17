package com.bfaydali.bookinventory.service

import com.bfaydali.bookinventory.model.entity.Author
import com.bfaydali.bookinventory.model.request.author.AuthorCreateRequest
import com.bfaydali.bookinventory.model.request.author.AuthorUpdateRequest
import com.bfaydali.bookinventory.model.response.AuthorResponse
import com.bfaydali.bookinventory.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {

    fun create(request: AuthorCreateRequest): AuthorResponse {
        val author = Author().apply {
            name = request.name
            surname = request.surname
        }
        return authorRepository.save(author).toResponse()
    }

    fun update(id: Long, request: AuthorUpdateRequest): AuthorResponse {
        val author = findAuthor(id).apply {
            name = request.name
            surname = request.surname
        }
        return authorRepository.save(author).toResponse()
    }

    fun getAll(): List<AuthorResponse> = authorRepository.findAll().map { it.toResponse() }

    fun get(id: Long): AuthorResponse = findAuthor(id).toResponse()

    fun delete(id: Long) = authorRepository.deleteById(id)

    fun findAuthor(id: Long) = authorRepository
        .findById(id)
        .orElseThrow { RuntimeException("Author not found") }
}