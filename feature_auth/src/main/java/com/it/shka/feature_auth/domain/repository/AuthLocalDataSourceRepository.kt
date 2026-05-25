package com.it.shka.feature_auth.domain.repository

import com.it.shka.feature_auth.domain.model.RegisterResponse

interface AuthLocalDataSourceRepository {
    suspend fun insertUserRoom(userToken: RegisterResponse): Result<Unit>

}