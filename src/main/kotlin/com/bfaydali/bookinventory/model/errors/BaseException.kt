package com.bfaydali.bookinventory.model.errors

import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class BaseException(override val message: String, val errors: Set<String>) : RuntimeException(message) {
    protected val log: Logger = LoggerFactory.getLogger(BaseException::class.java)
}
