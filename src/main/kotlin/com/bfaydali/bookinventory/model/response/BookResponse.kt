package com.bfaydali.bookinventory.model.response

data class BookResponse (
    var id: Long,
    var name: String,
    var author: String,
    var pageCount: Int,
)
