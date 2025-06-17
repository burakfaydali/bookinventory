package com.bfaydali.bookinventory.repository

import com.bfaydali.bookinventory.model.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long>