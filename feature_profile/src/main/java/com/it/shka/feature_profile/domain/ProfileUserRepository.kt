package com.it.shka.feature_profile.domain

import com.it.shka.feature_profile.domain.model.DataCourses

interface ProfileUserRepository {
    suspend fun getCoursesProfile(): Result<List<DataCourses>>
  //  suspend fun getCourseId(coursesId: Int): DataCourses
    suspend fun setTheoryCourse(courseId: Int, dataCourses: DataCourses?)
}