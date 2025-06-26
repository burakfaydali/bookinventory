package com.bfaydali.bookinventory.model.exception

abstract class BaseException(
    val key: String,
    val args: Array<String> = emptyArray(),
    override val message: String = "",
) : RuntimeException(message)
