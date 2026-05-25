package com.it.shka.feature_profile.domain

import com.it.shka.feature_profile.domain.model.DataCourses
import com.it.shka.feature_profile.domain.model.UserResponse

interface ProfileUserRepository {
    suspend fun getCoursesProfile(): Result<List<DataCourses>>
    suspend fun getUser(token: String): Result<UserResponse>
    suspend fun setTheoryCourse(courseId: Int, dataCourses: DataCourses?)
}