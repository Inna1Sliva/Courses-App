package com.it.shka.feature_onboarding.domain

import com.it.shka.feature_onboarding.domain.model.UserId
import com.it.shka.feature_onboarding.presentation.model.UserIdUi

interface DataRepository {
    suspend fun getUserId(): UserId?
}