package com.it.shka.feature_auth

class InputValidator {
    fun Validator (email: String): Boolean{
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailRegex.toRegex())
    }
}