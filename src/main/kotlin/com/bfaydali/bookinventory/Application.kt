package com.bfaydali.bookinventory

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition
@SpringBootApplication
class BookinventoryApplication

fun main(args: Array<String>) {
	runApplication<BookinventoryApplication>(*args)
}
