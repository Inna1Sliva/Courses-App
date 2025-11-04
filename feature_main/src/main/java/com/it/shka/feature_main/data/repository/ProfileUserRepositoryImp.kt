package com.it.shka.feature_main.data.repository

import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_main.data.mapper.toDataDomainCoursesProfile
import com.it.shka.feature_main.data.mapper.toDomainCoursesProfile
import com.it.shka.feature_main.domain.ProfileUserRepository
import com.it.shka.feature_main.domain.model.CoursesProfile
import com.it.shka.feature_main.presentation.mapper.toDomainDataCoursesProfile
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class ProfileUserRepositoryImp(private val api: ApiMainCourses): ProfileUserRepository {
    override suspend fun getCoursesProfile(): List<CoursesProfile>{
     return withContext(IO){api.getListCourse().toDomainCoursesProfile()}
    }

    override suspend fun getCourseId(courseId: Int): CoursesProfile {
        return withContext(IO){api.getCourseId(courseId).toDomainDataCoursesProfile()}
    }

    override suspend fun setTheoryCourse(
        courseId: Int,
        coursesProfile: CoursesProfile?
    ) {
       withContext(IO){
           api.setTheoryCourse(courseId,coursesProfile?.toDataDomainCoursesProfile())}
    }
}