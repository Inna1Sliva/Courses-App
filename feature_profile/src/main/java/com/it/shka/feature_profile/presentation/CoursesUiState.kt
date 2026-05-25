package com.it.shka.feature_profile.presentation

import com.it.shka.feature_profile.domain.model.UserResponse

sealed class CoursesUiState {
    data class Courses(val user: UserResponse): CoursesUiState()
    object Loading: CoursesUiState()
    object Error: CoursesUiState()
}