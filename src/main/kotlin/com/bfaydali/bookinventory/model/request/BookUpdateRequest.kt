package com.bfaydali.bookinventory.model.request

import com.bfaydali.bookinventory.model.entity.Book

data class BookUpdateRequest(
    var name: String,
    var pageCount: Int,
)