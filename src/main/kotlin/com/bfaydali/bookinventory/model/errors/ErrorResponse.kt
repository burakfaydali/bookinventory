package com.bfaydali.bookinventory.model.errors

data class ErrorResponse(
    var exception: String = "",
    var errors: List<ErrorDetailResponse> = emptyList()
)
