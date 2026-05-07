package com.it.shka.feature_main.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_main.data.mapper.toDomain
import com.it.shka.feature_main.domain.MainLocalDataSourceRepository
import com.it.shka.feature_main.domain.model.Courses
import kotlinx.coroutines.delay

class DataPagingSource(
    private val api: ApiMainCourses,
    private val local: MainLocalDataSourceRepository,
    private val query: String?
) : PagingSource<Int, Courses>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Courses> {
        delay(2000)
        val page = params.key ?: 1
        return try {
            val response = api.getCourses(page, query = query)
            val favoriteById = local.getFavoritesCourses().map { it.id }.toSet()
            LoadResult.Page(
                data = response.data.toDomain(favoriteById),
                prevKey = if (response.hasPrevPage) page - 1 else null,
                nextKey = if (response.hasNextPage) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)

        }

    }

    override fun getRefreshKey(state: PagingState<Int, Courses>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}