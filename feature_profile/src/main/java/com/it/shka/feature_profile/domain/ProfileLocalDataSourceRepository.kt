package com.it.shka.feature_profile.domain

import com.it.shka.feature_profile.domain.model.Token

interface ProfileLocalDataSourceRepository {
    suspend fun getToken(): Result<Token>
}