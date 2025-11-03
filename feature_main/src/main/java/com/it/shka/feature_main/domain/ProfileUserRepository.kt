package com.it.shka.feature_main.domain

import com.it.shka.feature_main.domain.model.Course
import com.it.shka.feature_main.domain.model.CoursesProfile

interface ProfileUserRepository {
    suspend fun getCoursesProfile(): List<CoursesProfile>
    suspend fun getCourseId(courseId: Int): CoursesProfile
    suspend fun setTheoryCourse(courseId: Int, coursesProfile: CoursesProfile)
}