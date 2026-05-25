package com.it.shka.feature_bottom_nav.data.repository

import com.it.shka.feature_bottom_nav.data.api.ApiServerBottomNav
import com.it.shka.feature_bottom_nav.domain.model.UserResponse
import com.it.shka.feature_bottom_nav.domain.repository.BottomNavRemoteDataSourceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BottomNavRemoteDataSourceRepositoryImp @Inject constructor(private val api: ApiServerBottomNav) :
    BottomNavRemoteDataSourceRepository {
    override suspend fun getUser(token: String):UserResponse {
        return withContext(Dispatchers.IO) {
            api.getUser(token)
           }
        }

}