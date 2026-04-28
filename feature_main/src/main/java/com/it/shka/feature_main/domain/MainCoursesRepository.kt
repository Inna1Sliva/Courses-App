package com.it.shka.feature_main.domain

import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.Page


interface MainCoursesRepository {

  suspend fun getPageCourse( page: Int): Page
  suspend fun getFavoritesCourses(): List<Courses>
  suspend fun setFavoritesCourses(courses: Courses): Result<Unit>
  suspend fun deleteCoursesId(id: Int): Result<Unit>


}