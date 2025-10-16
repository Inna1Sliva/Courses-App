package com.it.shka.feature_auth.domain

import com.it.shka.core.database.entity.UserIdEntity
import com.it.shka.feature_auth.data.model.User
import kotlinx.coroutines.flow.Flow

interface AuthUserRepository {
    suspend fun getEmailServer(email: String): User
    suspend fun setServerUser(user: User): Result
    suspend fun setDatabaseUserId(user: UserIdEntity): Result
    fun registerUser(user:User): Flow<Pair<Result, Result>>
     fun insertUserRoom(user: UserIdEntity): Flow<Result>
    fun insertUserServer(user: User): Flow<Result>
    fun validateEmail(email: String): Boolean
    fun validatePassword(password: String, repeatPassword: String): Boolean
}