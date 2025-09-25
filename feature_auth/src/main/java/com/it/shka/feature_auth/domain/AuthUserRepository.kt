package com.it.shka.feature_auth.domain

import com.it.shka.feature_auth.data.database.entity.UserIDEntity
import com.it.shka.feature_auth.data.model.User
import kotlinx.coroutines.flow.Flow

interface AuthUserRepository {
    suspend fun isEmailExists(email: String): Boolean
    suspend fun setServerUser(user: User): Result
    suspend fun setDatabaseUserId(user: UserIDEntity): Result
    fun registerUser(user:User): Flow<Pair<Result, Result>>
     fun insertUserRoom(user: UserIDEntity): Flow<Result>
    fun insertUserServer(user: User): Flow<Result>
    fun validateEmail(email: String): Boolean
    fun validatePassword(password: String, repidPassword: String): Boolean
}