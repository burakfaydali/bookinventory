package com.bfaydali.bookinventory.repository

import com.bfaydali.bookinventory.testutils.getAuthor
import com.bfaydali.bookinventory.testutils.getEmptyPage
import com.bfaydali.bookinventory.testutils.getPage
import com.bfaydali.bookinventory.testutils.getPageRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class AuthorRepositoryTest {

    @Autowired
    private lateinit var underTest: AuthorRepository

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Nested
    internal inner class FindAllByNameContainsIgnoreCase {

        @Test
        fun `it should find by name ignoring case`() {
            // given
            val author = getAuthor().apply {
                id = null
            }

            testEntityManager.persist(author)
            testEntityManager.flush()
            testEntityManager.clear()

            // when
            val actual = underTest.findAllByNameContainsIgnoreCase("NaM", getPageRequest())

            // then
            assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(getPage(author))
        }

        @Test
        fun `it should not find by name when no matching author exist`() {
            // given
            val author = getAuthor().apply {
                id = null
            }

            testEntityManager.persist(author)
            testEntityManager.flush()
            testEntityManager.clear()

            // when
            val actual = underTest.findAllByNameContainsIgnoreCase("hamdi", getPageRequest())

            // then
            assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(getEmptyPage())
        }
    }
}