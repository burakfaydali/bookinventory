package com.bfaydali.bookinventory.model.request.book

import com.bfaydali.bookinventory.model.entity.Author
import com.bfaydali.bookinventory.model.entity.Book
import com.bfaydali.bookinventory.model.enums.BookCategory

data class BookCreateRequest(
    var name: String,
    var authorId: Long,
    var pageCount: Int,
    var categories: Set<BookCategory>
) {

    fun toBook(author: Author) = Book(
        name,
        author,
        pageCount,
        categories
    )
}
