package com.bfaydali.bookinventory.controller

import com.bfaydali.bookinventory.model.request.author.AuthorCreateRequest
import com.bfaydali.bookinventory.model.response.AuthorResponse
import com.bfaydali.bookinventory.service.AuthorService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class AuthorControllerTest {

    @InjectMockKs
    private lateinit var underTest: AuthorController

    @MockK
    private lateinit var authorService: AuthorService

    @Nested
    internal inner class Create {

        @MockK
        private lateinit var request: AuthorCreateRequest

        @MockK
        private lateinit var response: AuthorResponse

        @Test
        fun `it should create author`() {
            // given
            every { authorService.create(request) } returns response

            // when
            val actual = underTest.create(request)

            // then
            assertThat(actual).isEqualTo(response)
        }
    }
}