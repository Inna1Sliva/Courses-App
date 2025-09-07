package com.it.shka.core.data.repository


import com.it.shka.core.data.api.ApiMainCourses
import com.it.shka.core.data.database.AppDatabase
import com.it.shka.core.data.database.entity.CoursesEntity
import com.it.shka.core.data.database.toCourses
import com.it.shka.core.data.database.toDomainCourses
import com.it.shka.core.data.mapper.toDomainPage
import com.it.shka.core.data.model.CoursesDto
import com.it.shka.core.domain.MainCoursesRepository
import com.it.shka.core.domain.model.Courses
import com.it.shka.core.domain.model.Page
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
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