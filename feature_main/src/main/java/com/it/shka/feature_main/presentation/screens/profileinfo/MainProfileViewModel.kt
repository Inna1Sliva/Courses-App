package com.it.shka.feature_main.presentation.screens.profileinfo


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.data.repository.ProfileUserRepositoryImp
import com.it.shka.feature_main.presentation.mapper.toDomainCoursesProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainProfileViewModel @Inject constructor(private val repository: ProfileUserRepositoryImp): ViewModel() {
    private val _viewModelState = MutableStateFlow(ProfileInfoState())
    val viewModelState: StateFlow<ProfileInfoState> get()=_viewModelState
    init {
        viewModelScope.launch {
            try {
                _viewModelState.update { it.copy(course = null, isLoading = true) }
                val course = repository.getCoursesProfile()
                _viewModelState.update { it.copy(course.toDomainCoursesProfile(), isLoading = false) }
            }catch (e:Exception) {
                _viewModelState.update {it.copy(error = true)
                }
            }
        }
    }
}