package com.bfaydali.bookinventory.controller

import com.bfaydali.bookinventory.model.enums.BookCategory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book-categories")
class BookCategoryController {

    @GetMapping
    fun getAll(): List<BookCategory> = BookCategory.entries
} 