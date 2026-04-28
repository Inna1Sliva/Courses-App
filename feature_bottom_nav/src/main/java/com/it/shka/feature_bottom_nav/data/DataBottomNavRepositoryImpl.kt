package com.it.shka.feature_bottom_nav.data


import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_bottom_nav.domain.repository.DataBottomNavRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataBottomNavRepositoryImpl @Inject constructor(private val db: AppDatabase) :
    DataBottomNavRepository {

    override  fun getCountFavorites(): Flow<Int> {
       return db.coursesDao().getCount()
    }
}