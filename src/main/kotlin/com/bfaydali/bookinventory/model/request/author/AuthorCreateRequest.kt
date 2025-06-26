package com.bfaydali.bookinventory.model.request.author

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AuthorCreateRequest(

    @field:NotBlank("author.create.request.name.not.blank")
    @field:Size(min = 2, max = 50, message = "author.create.request.name.size")
    var name: String? = null,

    @field:NotBlank("author.create.request.surname.not.blank")
    @field:Size(min = 2, max = 50, message = "author.create.request.surname.size")
    var surname: String? = null,
) 