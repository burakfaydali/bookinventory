package com.bfaydali.bookinventory.model.errors

class BusinessException(message: String) : BaseException(message, setOf()) {
    init {
        log.error("[BusinessException] -> message : {}", message)
    }
}
