package com.bfaydali.bookinventory.model.exception

import com.bfaydali.bookinventory.model.errors.ErrorDetailResponse
import com.bfaydali.bookinventory.model.errors.ErrorResponse
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

class DomainNotFoundException(key: String, vararg args: String) : BaseException(key, arrayOf(*args)) {

    fun toResponse(messageSource: MessageSource) = ErrorResponse(
        exception = "DomainNotFoundException",
        errors = listOf(
            ErrorDetailResponse(
                key = key,
                message = messageSource.getMessage(key, args, LocaleContextHolder.getLocale()),
            )
        )
    )
}