package com.it.shka.feature_profile.data

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_profile.data.mapper.toDomain
import com.it.shka.feature_profile.domain.ProfileLocalDataSourceRepository
import com.it.shka.feature_profile.domain.model.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileLocalDataSourceRepositoryImp @Inject constructor(private val local : AppDatabase): ProfileLocalDataSourceRepository {

    override suspend fun getToken(): Result<Token> {
        return withContext(Dispatchers.IO){
            runCatching {
                local.userTokenDao().getToken().toDomain()
            }
        }
    }
}