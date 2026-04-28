package com.it.shka.feature_main.data.repository

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_main.data.mapper.toDomainDataCourses
import com.it.shka.feature_main.data.mapper.toDomainPage
import com.it.shka.feature_main.domain.MainCoursesRepository
import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.Page
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainCoursesRepositoryImp @Inject constructor(
    private val api: ApiMainCourses,
    private val db: AppDatabase
) : MainCoursesRepository {

    override suspend fun getPageCourse(page: Int): Page {
        return withContext(Dispatchers.IO) { api.getCourses(page).toDomainPage() }
    }

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
