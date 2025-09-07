package com.it.shka.feature_auth

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ValidatorEmailTest {
    private val validator = InputValidator()
    @Test
    fun testValidEmails() {
        val validEmails = listOf(
            "test@example.com",
            "user.name@domain.co",
            "user_name@domain.com",
            "user-name@domain.org",
            "ininho94@mail.ru"
        )

        for (email in validEmails) {
            assertTrue( "Должен быть валидным: $email", validator.Validator(email))
        }
        
    }
    @Test
    fun testInvalidEmails() {
        val invalidEmails = listOf(
            "plainaddress",
            "@no-local-part.com",
            "outlook-contactdomain.com",
            "no-at.domain.com",
            "no-tld@domain",
            "user@.com"
        )

        for (email in invalidEmails) {
            assertFalse( "Должен быть невалидным: $email", validator.Validator(email))
        }
    }

}