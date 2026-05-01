package com.it.shka.feature_profile.presentation.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_profile.ProfileInfoState
import com.it.shka.feature_profile.domain.ProfileUserRepository
import com.it.shka.feature_profile.presentation.CoursesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainProfileViewModel @Inject constructor(private val repository: ProfileUserRepository): ViewModel() {
    private val _viewModelState = MutableStateFlow(ProfileInfoState())
    val viewModelState: StateFlow<ProfileInfoState> get()=_viewModelState
    private val _coursesUiState = MutableStateFlow<CoursesUiState>(CoursesUiState.Loading)
    val coursesUiState: StateFlow<CoursesUiState> get() = _coursesUiState
    init {
        viewModelScope.launch {
            _viewModelState.update { it.copy( isLoading = true) }
            repository.getCoursesProfile()
                .onSuccess { courses ->
                    _viewModelState.update { it.copy(courses, isLoading = false) }
                }
                .onFailure {
                    _viewModelState.update {it.copy(error = true)}
                    Log.e("MainProfileViewModel", "delete failed", it) }

            }
        }

    fun getCourseById(courseId: Int,mainTopicId: Int, subtopicId: Int){
        viewModelScope.launch {
            _coursesUiState.value = CoursesUiState.Loading
            repository.getCoursesProfile()
                .onSuccess { dataCourses ->
                    val courses = dataCourses.find { it.id == courseId }
                    dataCourses.map {
                        val up = it.courses.map { mainTopic ->
                            if (mainTopic.id == mainTopicId) {
                                val updateSubtopic = mainTopic.subtopics.map { subtopic ->
                                    if (subtopic.id == subtopicId) {
                                        subtopic.copy(status_id = true)
                                    } else subtopic
                                }
                                mainTopic.copy(subtopics = updateSubtopic)
                            } else mainTopic


                        }
                        _coursesUiState.value= CoursesUiState.Courses(dataCourses = courses!!, up)

                    }

                }
                .onFailure {
                    _coursesUiState.value = CoursesUiState.Error
                }
                }

        }




    fun setTheoryIdCourse(courseById:Int, theoryId: Int){
        viewModelScope.launch {
        //    _coursesUiState.value.courseProfile.let { data ->
           // val updateCourse = data?.copy(courses = data.courses.map {courses->
                 // courses.copy(subtopics = courses.subtopics.map {subtopic->
                    //  subtopic.copy(theory = subtopic.theory.map {theory->
                        // if (theory.id == theoryId){
                       //      theory.copy(status = true)
                       //  } else theory
                   //   })

                 // }
               // )

             // })
              // repository.setTheoryCourse(courseById,
                 // dataCourses = updateCourse
               // )
          //  }




        }
    }

}