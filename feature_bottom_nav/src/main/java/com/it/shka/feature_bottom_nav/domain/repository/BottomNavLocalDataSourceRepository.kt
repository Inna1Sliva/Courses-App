package com.it.shka.feature_bottom_nav.domain.repository

import kotlinx.coroutines.flow.Flow

interface BottomNavLocalDataSourceRepository {
    fun getCountFavorites(): Flow<Int>
    suspend fun getToken(): Result<String>
}