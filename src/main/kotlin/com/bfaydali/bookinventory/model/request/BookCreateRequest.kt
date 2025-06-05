package com.bfaydali.bookinventory.model.request

import com.bfaydali.bookinventory.model.entity.Book

data class BookCreateRequest(
    var id: Long,
    var name: String,
    var author: String,
    var pageCount: Int,
) {

    fun toBook() = Book(
        id = id,
        name = name,
        author = author,
        pageCount = pageCount,
    )
}
