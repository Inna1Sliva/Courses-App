package com.it.shka.feature_main.data.repository

import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_main.data.mapper.toDomainCoursesProfile
import com.it.shka.feature_main.domain.ProfileUserRepository
import com.it.shka.feature_main.domain.model.CoursesProfile
import kotlinx.coroutines.flow.Flow

class ProfileUserRepositoryImp(private val api: ApiMainCourses): ProfileUserRepository {
    override suspend fun getCoursesProfile():CoursesProfile{
     return api.getCourse().toDomainCoursesProfile()
    }
}