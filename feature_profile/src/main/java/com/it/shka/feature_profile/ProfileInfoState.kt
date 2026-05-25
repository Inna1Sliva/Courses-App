package com.it.shka.feature_profile

import com.it.shka.feature_profile.domain.model.DataCourses
import com.it.shka.feature_profile.domain.model.UserResponse

data class ProfileInfoState(
    val user: UserResponse? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false
)
