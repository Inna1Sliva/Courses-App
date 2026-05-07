package com.it.shka.feature_main.presentation.screens.coursesinfodetails

import com.it.shka.feature_main.domain.model.Courses

sealed class DetailsUiState {
    object Loading : DetailsUiState()
    data class Success(val courses: Courses): DetailsUiState()
    object Error: DetailsUiState()
}