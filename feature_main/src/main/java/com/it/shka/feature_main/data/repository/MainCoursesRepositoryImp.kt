package com.it.shka.feature_main.data.repository


import com.it.shka.core.database.data.AppDatabase
import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_main.data.mapper.toCourses
import com.it.shka.feature_main.data.mapper.toDomainCourses
import com.it.shka.feature_main.data.mapper.toDomainPage
import com.it.shka.feature_main.domain.MainCoursesRepository
import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.Page
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainCoursesRepositoryImp @Inject constructor(private val api: ApiMainCourses, private val db: AppDatabase) : MainCoursesRepository {

    override suspend fun getPageCourse(page: Int) : Page {
        return api.getCourses(page).toDomainPage() }

    override suspend fun getFavoritesCourses(): List<Courses> {
        return db.coursesDao().getAllCourses().toCourses()
    }

    override suspend fun setFavoritesCourses(courses: Courses) {
        db.coursesDao().insertCourses(courses.toDomainCourses())
    }
    override suspend fun deleteCoursesId(coursId: Int) {
        db.coursesDao().deleteCoursesId(coursId = coursId)
    }

    override fun getCountFavorites(): Flow<Int> {
        return db.coursesDao().getCount()
    }




}