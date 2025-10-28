package com.it.shka.feature_main.presentation.screens.profileinfo


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.data.repository.ProfileUserRepositoryImp
import com.it.shka.feature_main.presentation.mapper.toDomainCoursesProfile
import com.it.shka.feature_main.presentation.model.CourseUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainProfileViewModel @Inject constructor(private val repository: ProfileUserRepositoryImp): ViewModel() {
    private val _viewModelState = MutableStateFlow(ProfileInfoState())
    val viewModelState: StateFlow<ProfileInfoState> get()=_viewModelState
    private val _courseUi = MutableStateFlow(CourseInfoState())
    val courseUi: StateFlow<CourseInfoState> get() = _courseUi
    init {
        viewModelScope.launch {
            delay(2000)
            try {
                _viewModelState.update { it.copy( isLoading = true) }
                val course = repository.getCoursesProfile()
                _viewModelState.update { it.copy(course.toDomainCoursesProfile(), isLoading = false) }
            }catch (e:Exception) {
                println(e)
                _viewModelState.update {it.copy(error = true)
                }
            }
        }
    }
    fun setCourseUi(courseUi: List<CourseUi>){
        viewModelScope.launch {
            _courseUi.update {it.copy(course = courseUi)
            }
        }
    }
}