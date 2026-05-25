package com.it.shka.feature_bottom_nav.domain.repository

import com.it.shka.feature_bottom_nav.domain.model.UserResponse

interface BottomNavRemoteDataSourceRepository {
    suspend fun getUser(token: String): UserResponse
}