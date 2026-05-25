package com.it.shka.feature_auth.domain

interface EmailValidationUseCase {
    operator fun invoke(email: String): Boolean
}