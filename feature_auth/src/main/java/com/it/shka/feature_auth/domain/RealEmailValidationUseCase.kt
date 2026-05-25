package com.it.shka.feature_auth.domain

class RealEmailValidationUseCase: EmailValidationUseCase {
   override operator fun invoke(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        return (emailRegex.matches(email))!= true
    }
}