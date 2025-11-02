package com.it.shka.feature_main.presentation.screens.profileinfo


import com.it.shka.feature_main.presentation.model.CourseUi
import com.it.shka.feature_main.presentation.model.CoursesProfileUi

data class CourseInfoState(
    val courseProfile: CoursesProfileUi? = null,
    val course: List<CourseUi>? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false
)
