package com.it.shka.feature_onboarding.domain

interface DataRepository {
    suspend fun getUserId(): Int
}