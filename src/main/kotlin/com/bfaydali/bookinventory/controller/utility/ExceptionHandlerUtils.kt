package com.bfaydali.bookinventory.controller.utility

import com.bfaydali.bookinventory.model.errors.ErrorDetailResponse
import com.bfaydali.bookinventory.model.errors.ErrorResponse
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.DefaultMessageSourceResolvable
import org.springframework.validation.BindException
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MissingServletRequestParameterException

const val UNEXPECTED_ERROR_KEY: String = "unexpected.error"
const val ILLEGAL_ARGUMENT_ERROR_KEY: String = "illegal.argument.error"
const val MISSING_REQUEST_PARAM_ERROR_KEY: String = "missing.request.param.error"
const val INVALID_FORMAT_ERROR_KEY: String = "invalid.format.error"
const val JSON_PARSE_ERROR_KEY: String = "json.parse.error"

fun BindException.toResponse(messageSource: MessageSource) = ErrorResponse(
    exception = "BindException",
    errors = getBindErrorDetails(messageSource, bindingResult)
)

fun IllegalArgumentException.toResponse(messageSource: MessageSource) = anErrorResponse(
    messageSource,
    "IllegalArgumentException",
    ILLEGAL_ARGUMENT_ERROR_KEY
)

fun MissingServletRequestParameterException.toResponse(messageSource: MessageSource) = anErrorResponse(
    messageSource,
    "MissingServletRequestParameterException",
    MISSING_REQUEST_PARAM_ERROR_KEY,
    arrayOf(parameterName)
)

fun InvalidFormatException.toResponse(messageSource: MessageSource) = anErrorResponse(
    messageSource,
    "InvalidFormatException",
    INVALID_FORMAT_ERROR_KEY
)

fun JsonParseException.toResponse(messageSource: MessageSource) = anErrorResponse(
    messageSource,
    "JsonParseException",
    JSON_PARSE_ERROR_KEY
)

fun Exception.toResponse(messageSource: MessageSource) = anErrorResponse(
    messageSource,
    "UnexpectedError",
    UNEXPECTED_ERROR_KEY
)

fun anErrorResponse(
    messageSource: MessageSource,
    exceptionType: String,
    key: String,
    args: Array<String> = emptyArray()
) = ErrorResponse(
    exception = exceptionType,
    errors = listOf(
        ErrorDetailResponse(
            key = key,
            message = messageSource.getMessage(
                key,
                args,
                LocaleContextHolder.getLocale()
            ),
        )
    )
)

fun getBindErrorDetails(
    messageSource: MessageSource,
    bindingResult: BindingResult,
): List<ErrorDetailResponse> = bindingResult.allErrors.map { getErrorDetail(messageSource, it) }

fun getErrorDetail(
    messageSource: MessageSource,
    error: DefaultMessageSourceResolvable,
) = ErrorDetailResponse(
    key = error.defaultMessage ?: UNEXPECTED_ERROR_KEY,
    message = messageSource.getMessage(
        error.defaultMessage ?: UNEXPECTED_ERROR_KEY,
        error.arguments ?: emptyArray(),
        LocaleContextHolder.getLocale()
    )
)