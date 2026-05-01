package com.it.shka.feature_profile.presentation

import com.it.shka.feature_profile.domain.model.DataCourses

sealed class CoursesUiState {
    data class Courses(val dataCourses: DataCourses, val courses: List<com.it.shka.feature_profile.domain.model.Courses>): CoursesUiState()
    object Loading: CoursesUiState()
    object Error: CoursesUiState()
}