package com.bfaydali.bookinventory.model.request

import org.springframework.data.domain.PageRequest

data class AuthorFilterRequest(
    var page: Int? = 0,
    var size: Int? = 10,
    var name: String? = null
) {

    fun pageRequest() = PageRequest.of(page!!, size!!)
}