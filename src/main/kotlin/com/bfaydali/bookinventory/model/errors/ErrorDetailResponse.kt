package com.bfaydali.bookinventory.model.errors

data class ErrorDetailResponse(
    var key: String? = null,
    var message: String? = null,
    var errorCode: String? = null,
    var args: List<String> = emptyList(),
)
