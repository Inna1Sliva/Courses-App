package com.it.shka.feature_auth.domain

interface AuthUserRepository {
    fun isEmailExists(email: String, callback:(Boolean)->Unit)
    fun registerUser(email: String, password: String)
    fun validateEmail(email: String): Boolean
    fun validatePassword(password: String, repidPassword: String): Boolean
}