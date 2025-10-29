package com.it.shka.feature_main.presentation.screens.profileinfo


import com.it.shka.feature_main.presentation.model.CoursesProfileUi

data class CourseInfoState(
    val course: CoursesProfileUi? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false
)
