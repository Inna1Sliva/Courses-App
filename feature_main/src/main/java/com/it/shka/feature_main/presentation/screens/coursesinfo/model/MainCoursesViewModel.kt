package com.it.shka.feature_main.presentation.screens.coursesinfo.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.it.shka.feature_main.domain.MainLocalDataSourceRepository
import com.it.shka.feature_main.domain.MainRemoteDataSourceRepository
import com.it.shka.feature_main.domain.model.Courses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainCoursesViewModel @Inject constructor(
    private val remote: MainRemoteDataSourceRepository,
    private val local: MainLocalDataSourceRepository
) : ViewModel() {
    val _searchQuery = MutableStateFlow<String?>(null)
    val searchQuery: StateFlow<String?> = _searchQuery
    val _pageCourses = MutableStateFlow<PagingData<Courses>>(PagingData.Companion.empty())
  val pageCourses: StateFlow<PagingData<Courses>> = _pageCourses
    private val _coursesDetail = MutableStateFlow<List<Courses>>(emptyList())
    val coursesDetail: StateFlow<List<Courses>> = _coursesDetail

    init {
        loadCourses()
    }

    fun deleteDbId(id: Int) {
        viewModelScope.launch {
            local.deleteCoursesId(id = id)
                .onFailure {
                    Log.e("MainCoursesViewModel", "delete failed", it)
                }
        }
    }

    fun insertDb(courses: Courses) {
        viewModelScope.launch {
            local.setFavoritesCourses(courses)
                .onFailure { Log.e("MainCoursesViewModel", "seve failed", it) }
        }
    }
    fun setSearchQuery(query: String) {
        _searchQuery.value = if (query.isBlank()) null else query
        loadCourses()
    }
    private fun loadCourses() {
       viewModelScope.launch {
           remote.pagingCourses(_searchQuery.value)
               .cachedIn(viewModelScope)
               .collectLatest { pagingData ->
                   _pageCourses.value = pagingData

               }

       }
    }

}