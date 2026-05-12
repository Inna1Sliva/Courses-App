package com.it.shka.feature_main.domain

import androidx.paging.PagingData
import com.it.shka.feature_main.domain.model.Courses
import kotlinx.coroutines.flow.Flow


interface MainRemoteDataSourceRepository {
     suspend fun pagingCourses(query: String?): Result<Flow<PagingData<Courses>>>
    suspend fun getCourseById(courseId: String): Result<Courses>

}