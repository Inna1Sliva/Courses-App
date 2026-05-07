package com.it.shka.feature_main.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_main.data.mapper.toDataDomainCourses
import com.it.shka.feature_main.data.mapper.toDomainDataCourses
import com.it.shka.feature_main.data.paging.DataPagingSource
import com.it.shka.feature_main.domain.MainLocalDataSourceRepository
import com.it.shka.feature_main.domain.MainRemoteDataSourceRepository
import com.it.shka.feature_main.domain.model.Courses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRemoteDataSourceRepositoryImp @Inject constructor(
    private val api: ApiMainCourses,
    private val local: MainLocalDataSourceRepository
) : MainRemoteDataSourceRepository {
    override fun pagingCourses(query: String?): Flow<PagingData<Courses>> {
       return Pager(
            config = PagingConfig(pageSize = 10, prefetchDistance = 7),
            pagingSourceFactory = {
                DataPagingSource(api, local, query)
            }
        ).flow
    }

    override suspend fun getCourseById(courseId: String): Result<Courses> {
        return withContext(Dispatchers.IO){
            delay(3000)
            val favoriteById = local.getFavoritesCourses().map { it.id }.toSet()
            runCatching { api.getCourseById(courseId).toDataDomainCourses(favoriteById)}
        }
    }


}
