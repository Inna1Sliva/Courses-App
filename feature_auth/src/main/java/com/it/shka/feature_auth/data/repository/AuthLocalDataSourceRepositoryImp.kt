package com.it.shka.feature_auth.data.repository

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_auth.data.toDomain
import com.it.shka.feature_auth.domain.model.RegisterResponse
import com.it.shka.feature_auth.domain.repository.AuthLocalDataSourceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthLocalDataSourceRepositoryImp @Inject constructor( private val db: AppDatabase): AuthLocalDataSourceRepository {
    override suspend fun insertUserRoom(userToken: RegisterResponse): Result<Unit> {
      return  withContext(Dispatchers.IO) {
            runCatching {
                db.userTokenDao().setUserToken(userToken.toDomain())
            }
        }
    }
}