package com.it.shka.feature_main.data.repository

import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_main.data.mapper.toDomainCourse
import com.it.shka.feature_main.data.mapper.toDomainCoursesProfile
import com.it.shka.feature_main.domain.ProfileUserRepository
import com.it.shka.feature_main.domain.model.Course
import com.it.shka.feature_main.domain.model.CoursesProfile
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class ProfileUserRepositoryImp(private val api: ApiMainCourses): ProfileUserRepository {
    override suspend fun getCoursesProfile(): List<CoursesProfile>{
     return withContext(IO){api.getListCourse().toDomainCoursesProfile()}
    }

    override suspend fun getCourseId(courseId: Int): List<CoursesProfile> {
        return withContext(IO){api.getCourseId(courseId).toDomainCoursesProfile()}
    }
}