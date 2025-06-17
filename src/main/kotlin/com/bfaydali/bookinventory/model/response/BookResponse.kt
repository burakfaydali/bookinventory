package com.bfaydali.bookinventory.model.response

import com.bfaydali.bookinventory.model.enums.BookCategory

data class BookResponse (
    var id: Long,
    var name: String,
    var author: AuthorResponse,
    var pageCount: Int,
    var categories: Set<BookCategory> = setOf()
)