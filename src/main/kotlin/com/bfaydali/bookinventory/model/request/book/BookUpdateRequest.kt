package com.bfaydali.bookinventory.model.request.book

import com.bfaydali.bookinventory.model.enums.BookCategory

data class BookUpdateRequest(
    var name: String,
    var pageCount: Int,
    var categories: Set<BookCategory>
)