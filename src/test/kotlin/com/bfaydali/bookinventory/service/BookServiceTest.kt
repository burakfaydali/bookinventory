package com.bfaydali.bookinventory.service

import com.bfaydali.bookinventory.model.request.BookCreateRequest
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class BookServiceTest {

    @InjectMockKs
    private lateinit var underTest: BookService

    @Test
    fun it_should_create_book() {
        // given

        // when

        // then

    }
}