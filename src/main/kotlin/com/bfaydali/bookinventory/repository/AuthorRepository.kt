package com.bfaydali.bookinventory.repository

import com.bfaydali.bookinventory.model.entity.Author
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long>, PagingAndSortingRepository<Author, Long> {

    fun findAllByNameContainsIgnoreCase(name: String, pageable: Pageable): Page<Author>
}