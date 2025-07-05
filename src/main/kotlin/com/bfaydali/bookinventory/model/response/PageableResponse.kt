package com.bfaydali.bookinventory.model.response

data class PageableResponse<T>(
    var totalElements: Long = 0,
    var totalPages: Int = 0,
    var page: Int = 0,
    var size: Int = 0,
    var content: Collection<T> = emptyList(),
)
