package com.it.shka.feature_main.domain

import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.Page

import kotlinx.coroutines.flow.Flow

interface MainCoursesRepository {
  suspend fun getPageCourse( page: Int): Page
  suspend fun getFavoritesCourses(): List<Courses>
  suspend fun setFavoritesCourses(courses: Courses)
  suspend fun deleteCoursesId(coursId: Int)
  fun getCountFavorites(): Flow<Int>

}