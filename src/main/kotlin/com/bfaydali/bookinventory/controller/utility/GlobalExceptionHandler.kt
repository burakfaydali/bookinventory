package com.bfaydali.bookinventory.controller.utility

import com.bfaydali.bookinventory.model.errors.ErrorResponse
import com.bfaydali.bookinventory.model.exception.BusinessException
import com.bfaydali.bookinventory.model.exception.DomainNotFoundException
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.apache.commons.lang3.exception.ExceptionUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler(
    private val messageSource: MessageSource
) {

    val logger: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(DomainNotFoundException::class)
    fun handleDomainNotFoundException(exception: DomainNotFoundException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("DomainNotFoundException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(response)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(exception: BusinessException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("BusinessException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

    @ExceptionHandler(BindException::class)
    fun handleBindException(exception: BindException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("BindException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("MethodArgumentNotValidException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("IllegalArgumentException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingServletRequestParameterException(exception: MissingServletRequestParameterException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("MissingServletRequestParameterException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> =
        when (val throwable = ExceptionUtils.getRootCause(exception)) {
            is InvalidFormatException -> handleInvalidFormatException(throwable)
            is JsonParseException -> handleJsonParseException(throwable)
            else -> handleUnexpectedException(Exception(throwable))
        }

    private fun handleInvalidFormatException(exception: InvalidFormatException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("InvalidFormatException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

    private fun handleJsonParseException(exception: JsonParseException): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("JsonParseException occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }

    private fun handleUnexpectedException(exception: Exception): ResponseEntity<ErrorResponse> {
        val response = exception.toResponse(messageSource)

        logger.error("Exception occurred. Caused by $response")

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response)
    }
}