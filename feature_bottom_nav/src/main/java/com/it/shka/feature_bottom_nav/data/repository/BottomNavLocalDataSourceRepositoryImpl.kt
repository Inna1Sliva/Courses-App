package com.it.shka.feature_bottom_nav.data.repository

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_bottom_nav.domain.repository.BottomNavLocalDataSourceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BottomNavLocalDataSourceRepositoryImpl @Inject constructor(private val local: AppDatabase) :
    BottomNavLocalDataSourceRepository {

    override  fun getCountFavorites(): Flow<Int> {
       return local.coursesDao().getCount()
    }
    override suspend fun getToken(): Result<String> {
        return withContext(Dispatchers.IO){
            runCatching {
                local.userTokenDao().getToken().token
            }
        }
    }
}