package com.bfaydali.bookinventory.testutils

import com.bfaydali.bookinventory.model.request.author.AuthorCreateRequest
import com.bfaydali.bookinventory.model.response.AuthorResponse

fun getAuthorCreateRequest() = AuthorCreateRequest(
    name = "name",
    surname = "surname",
)

fun getAuthorResponse() = AuthorResponse(
    id = 1,
    name = "name",
    surname = "surname",
)