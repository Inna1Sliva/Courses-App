package com.it.shka.feature_main.presentation.screens.coursesinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.it.shka.feature_main.data.repository.MainCoursesRepositoryImp
import com.it.shka.feature_main.presentation.mapper.toCoursesDomain
import com.it.shka.feature_main.presentation.model.CoursesModel
import com.it.shka.feature_main.presentation.paging.MainPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainCoursesViewModel @Inject constructor(private val repositoryImp: MainCoursesRepositoryImp): ViewModel() {
   // val courses: StateFlow<List<CoursesDto>> = repositoryImp.courses
    val pageCourses : Flow<PagingData<CoursesModel>> = getPage()
    val badgeFavorites : StateFlow<Int> =repositoryImp.getCountFavorites().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = 0
    )
    private val _coursesDetail = MutableStateFlow<List<CoursesModel>>(emptyList())
    val coursesDetail: StateFlow<List<CoursesModel>> get() = _coursesDetail
    private val _isLoading = MutableStateFlow(false)
    val stateAppBar = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
   // val courses: StateFlow<List<Courses>> = repositoryImp.courses

    fun getPage(): Flow<PagingData<CoursesModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                MainPagingSource(repositoryImp)
            }
        ).flow.cachedIn(viewModelScope)
    }

    fun setDetailCourses(courses: CoursesModel){
        viewModelScope.launch {
            val detail = mutableListOf<CoursesModel>()
            detail.add(courses)
            _coursesDetail.value = detail
        }
    }
    fun deleteDbId(coursId: Int){
        viewModelScope.launch {
            try {
                repositoryImp.deleteCoursesId(coursId = coursId)
            }catch (e: Exception){
                println(e)
            }
        }
    }
    fun insertDb(courses: CoursesModel){
        viewModelScope.launch {
            try{
                repositoryImp.setFavoritesCourses(courses.toCoursesDomain())
            }catch (e: Exception){
                println(e)
            }
        }


    }

}