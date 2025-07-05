package com.bfaydali.bookinventory.extension

import com.bfaydali.bookinventory.model.response.PageableResponse
import org.springframework.data.domain.Page

fun <T> Page<T>.toPageableResponse() = PageableResponse(
    totalElements,
    totalPages,
    number,
    size,
    content,
)