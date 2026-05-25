package com.it.shka.feature_auth.data.repository

import com.it.shka.feature_auth.data.api.ApiAuthUsers
import com.it.shka.feature_auth.domain.model.RegisterRequest
import com.it.shka.feature_auth.domain.repository.AuthRemoteDataSourceRepository
import com.it.shka.feature_auth.domain.model.RegisterResponse
import com.it.shka.feature_auth.domain.model.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRemoteDataSourceRepositoryImp @Inject constructor(
    private val api: ApiAuthUsers
) : AuthRemoteDataSourceRepository {

    override suspend fun getUsersEmail(): List<UsersResponse> {
        return withContext(Dispatchers.IO){
          api.getUsersEmail()
        }
    }


    override suspend fun registerUser(user: RegisterRequest): Result<RegisterResponse> {
        return withContext(Dispatchers.IO) {
            runCatching {
                delay(4000L)
                api.registerUser(user)
            }
        }
    }





}