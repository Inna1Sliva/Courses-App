package com.it.shka.feature_auth.domain.repository

import com.it.shka.feature_auth.domain.model.RegisterRequest
import com.it.shka.feature_auth.domain.model.RegisterResponse
import com.it.shka.feature_auth.domain.model.UsersResponse

interface AuthRemoteDataSourceRepository {
    suspend fun registerUser(user: RegisterRequest): Result<RegisterResponse>
    suspend fun getUsersEmail(): List<UsersResponse>


}