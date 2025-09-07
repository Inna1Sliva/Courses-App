package com.it.shka.core.domain

import androidx.compose.runtime.ShouldPauseCallback
import androidx.paging.PagingData
import com.it.shka.core.data.database.entity.CoursesEntity
import com.it.shka.core.domain.model.Courses
import com.it.shka.core.domain.model.Page

import kotlinx.coroutines.flow.Flow

interface MainCoursesRepository {
  suspend fun getPageCourse( page: Int): Page
  suspend fun getFavoritesCourses(): List<Courses>
  suspend fun setFavoritesCourses(courses: Courses)
  suspend fun deleteCoursesId(coursId: Int)
  fun getCountFavorites(): Flow<Int>

}