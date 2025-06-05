package com.bfaydali.bookinventory.model.entity

import com.bfaydali.bookinventory.model.response.BookResponse

data class Book(
    var id: Long,
    var name: String,
    var author: String,
    var pageCount: Int,
) {

    fun toBookResponse() = BookResponse(
        id = id,
        name = name,
        author = author,
        pageCount = pageCount,
    )
}
