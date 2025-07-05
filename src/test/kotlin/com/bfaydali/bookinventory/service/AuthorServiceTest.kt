package com.bfaydali.bookinventory.service

import com.bfaydali.bookinventory.repository.AuthorRepository
import com.bfaydali.bookinventory.testutils.*
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class AuthorServiceTest {

    @InjectMockKs
    private lateinit var underTest: AuthorService

    @MockK
    private lateinit var authorRepository: AuthorRepository

    @Nested
    inner class GetAll {

        @Test
        fun `it should return all authors when name filter is null`() {
            // given
            every { authorRepository.findAll(getPageRequest()) } returns getPage(getAuthor())

            // when
            val actual = underTest.getAll(getAuthorFilterRequest())

            // then
            assertThat(actual).isEqualTo(getPageableResponse(getAuthorResponse()))
        }

        @Test
        fun `it should return filtered authors when name filter is provided`() {
            // given
            val request = getAuthorFilterRequest().apply {
                name = "burak"
            }

            every { authorRepository.findAllByNameContainsIgnoreCase("burak", getPageRequest()) } returns getPage(
                getAuthor()
            )

            // when
            val result = underTest.getAll(request)

            // then
            assertThat(result).isEqualTo(getPageableResponse(getAuthorResponse()))
        }
    }
}