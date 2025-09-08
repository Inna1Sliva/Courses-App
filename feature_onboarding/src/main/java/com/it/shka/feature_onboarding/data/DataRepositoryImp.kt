package com.it.shka.feature_onboarding.data

import com.it.shka.feature_onboarding.data.database.AppUserDatabase
import com.it.shka.feature_onboarding.data.database.mapper.toDomainUserId
import com.it.shka.feature_onboarding.domain.DataRepository
import com.it.shka.feature_onboarding.domain.model.UserId
import com.it.shka.feature_onboarding.presentation.model.UserIdUi
import javax.inject.Inject

class DataRepositoryImp @Inject constructor(private val db: AppUserDatabase): DataRepository {
    override suspend fun getUserId(): UserId? {
        return db.userIdDao().getUserId()?.toDomainUserId()
    }
}