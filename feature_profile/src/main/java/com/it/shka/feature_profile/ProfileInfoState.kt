package com.it.shka.feature_profile

import com.it.shka.feature_profile.domain.model.DataCourses

data class ProfileInfoState(
    val course: List<DataCourses>? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false
)
