package com.bfaydali.bookinventory.testutils

import com.bfaydali.bookinventory.model.entity.Author
import com.bfaydali.bookinventory.model.request.AuthorFilterRequest
import com.bfaydali.bookinventory.model.request.author.AuthorCreateRequest
import com.bfaydali.bookinventory.model.response.AuthorResponse
import com.bfaydali.bookinventory.model.response.PageableResponse
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest

fun getAuthorCreateRequest() = AuthorCreateRequest(
    name = "name",
    surname = "surname",
)

fun getAuthorResponse() = AuthorResponse(
    id = 1,
    name = "name",
    surname = "surname",
)

fun getAuthor() = Author().apply {
    id = 1
    name = "name"
    surname = "surname"
    books = mutableListOf()
}

fun getAuthorFilterRequest() = AuthorFilterRequest(
    page = 0,
    size = 10,
    name = null
)

fun getPageRequest() = PageRequest.of(0, 10)

fun <T> getPage(content: T) = PageImpl(listOf(content), getPageRequest(), 1)

fun getEmptyPage() = PageImpl<Any>(listOf(), getPageRequest(), 1)

fun <T> getPageableResponse(content: T) = PageableResponse(
    totalElements = 1,
    totalPages = 1,
    page = 0,
    size = 10,
    content = listOf(content)
)