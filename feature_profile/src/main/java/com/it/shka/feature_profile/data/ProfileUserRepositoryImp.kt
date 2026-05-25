package com.it.shka.feature_profile.data

import com.it.shka.feature_profile.data.api.ApiProfileCourses
import com.it.shka.feature_profile.domain.ProfileUserRepository
import com.it.shka.feature_profile.domain.model.DataCourses
import com.it.shka.feature_profile.domain.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileUserRepositoryImp @Inject constructor(private val api: ApiProfileCourses): ProfileUserRepository {
    override suspend fun getCoursesProfile(): Result<List<DataCourses>> {
        return withContext(Dispatchers.IO){
            runCatching {
                delay(2000)
                api.getListCourse() }}
    }

    override suspend fun getUser(token: String): Result<UserResponse> {
        return withContext(Dispatchers.IO){
            runCatching {
                api.getUser(token)
            }
        }
    }

    override suspend fun setTheoryCourse(
        courseId: Int,
        dataCourses: DataCourses?
    ) {
        api.setTheoryCourse(courseId, dataCourses)
    }


}