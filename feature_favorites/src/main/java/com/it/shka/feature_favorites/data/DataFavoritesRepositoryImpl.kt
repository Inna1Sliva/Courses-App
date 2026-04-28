package com.it.shka.feature_favorites.data

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_favorites.domain.model.Courses
import com.it.shka.feature_favorites.domain.repository.DataFavoritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataFavoritesRepositoryImpl @Inject constructor(private val db: AppDatabase) :
    DataFavoritesRepository {
    override suspend fun getFavoritesCourses(): Result<List<Courses>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                delay(3000)
                db.coursesDao().getAllCourses().toDomainCourses()
            }

        }
    }

    override suspend fun deleteCoursesId(id: Int): Result<Unit> {
       return withContext(Dispatchers.IO) {
           runCatching { db.coursesDao().deleteCoursesId(coursId = id) }
       }
    }
}