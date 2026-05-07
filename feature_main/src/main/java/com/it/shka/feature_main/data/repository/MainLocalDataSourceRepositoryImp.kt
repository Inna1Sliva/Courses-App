package com.it.shka.feature_main.data.repository

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_main.data.mapper.toDomainDataCourses
import com.it.shka.feature_main.domain.MainLocalDataSourceRepository
import com.it.shka.feature_main.domain.model.Courses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

 class MainLocalDataSourceRepositoryImp @Inject constructor(private val db: AppDatabase): MainLocalDataSourceRepository {
     override suspend fun getFavoritesCourses(): List<Courses> {
         return withContext(Dispatchers.IO) {
             db.coursesDao().getAllCourses().toDomainDataCourses()
         }
     }

     override suspend fun setFavoritesCourses(courses: Courses): Result<Unit> {
         return withContext(Dispatchers.IO) {
             runCatching {
                 db.coursesDao().insertCourses(courses.toDomainDataCourses())
             }
         }
     }

     override suspend fun deleteCoursesId(id: Int): Result<Unit> {
         return withContext(Dispatchers.IO) {
             runCatching { db.coursesDao().deleteCoursesId(coursId = id) }
         }
     }

 }