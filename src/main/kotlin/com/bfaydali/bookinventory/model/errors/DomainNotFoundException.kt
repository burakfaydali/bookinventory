package com.bfaydali.bookinventory.model.errors

class DomainNotFoundException(message: String) : BaseException(message, setOf()) {
    init {
        log.error("[DomainNotFoundException] -> message : {}", message)
    }
}
