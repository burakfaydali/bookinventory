package com.bfaydali.bookinventory.model.request

data class BookUpdateRequest(
    var name: String,
    var pageCount: Int,
)