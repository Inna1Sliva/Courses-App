package com.it.shka.feature_onboarding.data.repository

import com.it.shka.core.database.data.AppDatabase
import com.it.shka.feature_onboarding.domain.DataRepository
import javax.inject.Inject

class DataRepositoryImp @Inject constructor(private val db: AppDatabase): DataRepository {
    override suspend fun getUserId(): Int {
        return db.userIdDao().getUserId()
    }
}