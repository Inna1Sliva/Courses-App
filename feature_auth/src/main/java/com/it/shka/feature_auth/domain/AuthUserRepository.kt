package com.it.shka.feature_auth.domain

import com.it.shka.core.data.entity.UserTokenEntity
import com.it.shka.feature_auth.data.model.User
import kotlinx.coroutines.flow.Flow

interface AuthUserRepository {
    suspend fun getEmailServer(): List<User>
    suspend fun setServerUser(user: User): Result
    suspend fun setDatabaseUserId(user: UserTokenEntity): Result
    suspend fun registerUser(user:User): Result<UserToken>
     fun insertUserRoom(user: UserTokenEntity): Flow<Result>
    fun insertUserServer(user: User): Flow<Result>
    fun validateEmail(email: String): Boolean
    fun validatePassword(password: String, repeatPassword: String): Boolean
}