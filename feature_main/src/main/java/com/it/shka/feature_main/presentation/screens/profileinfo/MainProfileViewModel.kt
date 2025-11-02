package com.it.shka.feature_main.presentation.screens.profileinfo


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.data.repository.ProfileUserRepositoryImp
import com.it.shka.feature_main.presentation.mapper.toDomainCourses
import com.it.shka.feature_main.presentation.mapper.toDomainCoursesProfile
import com.it.shka.feature_main.presentation.mapper.toDomainDataCoursesProfile
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
    private val _courseUiState = MutableStateFlow(CourseInfoState())
    val courseUiState: StateFlow<CourseInfoState> get() = _courseUiState
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
    fun getCourseById(courseId: Int,mainTopicId: Int, subtopicId: Int){
        viewModelScope.launch {
            try {
                _courseUiState.update {it.copy(isLoading = true) }
                val courseProfile = repository.getCoursesProfile()
                val courseId = courseProfile.find { it.id == courseId}
                val updateCourse = courseId?.cours?.map { mainTopic ->
                    if (mainTopic.id == mainTopicId){
                        val updateSubtopic = mainTopic.subtopics.map { subtopic->
                            if (subtopic.id == subtopicId){
                                subtopic.copy(status_id = true)
                            }else subtopic
                        }
                        mainTopic.copy(subtopics = updateSubtopic)
                    }else mainTopic
                }
                _courseUiState.update { it.copy(courseProfile = courseId?.toDomainDataCoursesProfile(), course =updateCourse?.toDomainCourses(), isLoading = false) }
            }catch (e: Exception){
                _courseUiState.update { it.copy(isLoading = false, error = true) }
            }
        }
    }

}