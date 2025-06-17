package com.bfaydali.bookinventory.controller.utility

import com.bfaydali.bookinventory.model.errors.DomainNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(DomainNotFoundException::class)
    fun handleDomainNotFoundException(exception: DomainNotFoundException): ResponseEntity<Any?> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(messageSource?.getMessage(exception.message, null, Locale.of("TR")))
    }
}