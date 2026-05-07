package com.it.shka.feature_main.presentation.screens.coursesinfodetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.domain.MainLocalDataSourceRepository
import com.it.shka.feature_main.domain.MainRemoteDataSourceRepository
import com.it.shka.feature_main.domain.model.Courses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainDetailsViewModel @Inject constructor(
    private val remote: MainRemoteDataSourceRepository,
    private val local: MainLocalDataSourceRepository
) : ViewModel() {
    private val _detailsUIState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val detailsUIState: StateFlow<DetailsUiState> = _detailsUIState

    fun LoadByIdCourses(coursesId: String) {
        viewModelScope.launch {
            remote.getCourseById(courseId = coursesId)
                .onSuccess {
                    _detailsUIState.value = DetailsUiState.Success(it)
                }
                .onFailure {
                    Log.e("MainDetailsViewModel", "get courses failed", it)
                }
        }
    }

    fun deleteDbId(id: Int) {
        viewModelScope.launch {
            local.deleteCoursesId(id = id)
                .onFailure {
                    Log.e("MainDetailsViewModel", "delete failed", it)
                }
        }
    }
    fun insertDb(courses: Courses) {
        viewModelScope.launch {
            local.setFavoritesCourses(courses)
                .onFailure { Log.e("MainDetailsViewModel", "seve failed", it) }
        }
    }

}