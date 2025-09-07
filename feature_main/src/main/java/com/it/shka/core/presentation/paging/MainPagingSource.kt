package com.it.shka.core.presentation.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.it.shka.core.data.repository.MainCoursesRepositoryImp
import com.it.shka.core.domain.model.Courses
import com.it.shka.core.presentation.mapper.toDomain
import com.it.shka.core.presentation.model.CoursesModel
import kotlinx.coroutines.delay

class MainPagingSource (private val repositoryImp: MainCoursesRepositoryImp): PagingSource<Int, CoursesModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CoursesModel> {
        delay(7000)
        var page = params.key ?: 1
        return try {
            var response=repositoryImp.getPageCourse(page)
            val favoriteById = repositoryImp.getFavoritesCourses().map{ it.id }.toSet()
            LoadResult.Page(
             data = response.data.toDomain(favoriteById),
             prevKey = if (page ==1) null else page- 1,
             nextKey = response.next
         )

     }catch (e: Exception){
         LoadResult.Error(e)

     }


    }

    override fun getRefreshKey(state: PagingState<Int, CoursesModel>): Int? {
       return state.anchorPosition?.let { anchorPosition->
           state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
               ?:state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
       }
    }
}