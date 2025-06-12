package com.bfaydali.bookinventory.repository

import com.bfaydali.bookinventory.model.entity.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long>