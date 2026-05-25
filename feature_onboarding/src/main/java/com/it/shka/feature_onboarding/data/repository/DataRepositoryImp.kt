package com.it.shka.feature_onboarding.data.repository

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_onboarding.domain.DataRepository
import javax.inject.Inject

class DataRepositoryImp @Inject constructor(private val db: AppDatabase): DataRepository {
    override suspend fun getTokenCount(): Int {
        return db.userTokenDao().getTokenCount()
    }
}