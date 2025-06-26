package com.bfaydali.bookinventory.controller

import com.bfaydali.bookinventory.model.request.author.AuthorCreateRequest
import com.bfaydali.bookinventory.service.AuthorService
import com.bfaydali.bookinventory.testutils.getAuthorCreateRequest
import com.bfaydali.bookinventory.testutils.getAuthorResponse
import com.bfaydali.bookinventory.testutils.jsonContent
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.Called
import io.mockk.every
import io.mockk.verify
import org.apache.commons.lang3.StringUtils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest(AuthorController::class)
class AuthorControllerIT {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockkBean
    private lateinit var authorService: AuthorService

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    internal inner class Create {

        private fun invalidCaseArguments() = listOf(
            Arguments.of(
                getAuthorCreateRequest().apply { name = null },
                "author.create.request.name.not.blank"
            ),
            Arguments.of(
                getAuthorCreateRequest().apply { name = "   " },
                "author.create.request.name.not.blank"
            ),
            Arguments.of(
                getAuthorCreateRequest().apply { name = "b" },
                "author.create.request.name.size"
            ),
            Arguments.of(
                getAuthorCreateRequest().apply { name = StringUtils.repeat('b', 51) },
                "author.create.request.name.size"
            ),
            Arguments.of(
                getAuthorCreateRequest().apply { surname = null },
                "author.create.request.surname.not.blank"
            ),
            Arguments.of(
                getAuthorCreateRequest().apply { surname = "   " },
                "author.create.request.surname.not.blank"
            ),
            Arguments.of(
                getAuthorCreateRequest().apply { surname = "b" },
                "author.create.request.surname.size"
            ),
            Arguments.of(
                getAuthorCreateRequest().apply { surname = StringUtils.repeat('b', 51) },
                "author.create.request.surname.size"
            ),
        )

        @ParameterizedTest
        @MethodSource("invalidCaseArguments")
        fun `it should validate request`(request: AuthorCreateRequest, expectedErrorKey: String) {
            // given

            // when
            val resultActions = mockMvc.post("/authors") {
                jsonContent(objectMapper.writeValueAsString(request))
            }

            // then
            resultActions.andExpect {
                status { isBadRequest() }
                jsonPath("$.exception") { value("BindException") }
                jsonPath("$.errors") { isNotEmpty() }
                jsonPath("$.errors[0].key") { value(expectedErrorKey) }
            }

            verify { authorService wasNot Called }
        }

        @Test
        fun `it should create author`() {
            // given
            every { authorService.create(getAuthorCreateRequest()) } returns getAuthorResponse()

            // when
            val resultActions = mockMvc.post("/authors") {
                jsonContent(objectMapper.writeValueAsString(getAuthorCreateRequest()))
            }

            // then
            resultActions.andExpect {
                status { isCreated() }
                content { json(objectMapper.writeValueAsString(getAuthorResponse())) }
            }
        }
    }
}