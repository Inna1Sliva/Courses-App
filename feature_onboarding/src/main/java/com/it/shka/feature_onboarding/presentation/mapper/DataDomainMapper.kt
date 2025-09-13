package com.it.shka.feature_onboarding.presentation.mapper

import com.it.shka.feature_onboarding.domain.model.UserId
import com.it.shka.feature_onboarding.presentation.model.UserIdUi

fun UserId.toDomainUserId(): UserIdUi{
    return UserIdUi(
        authId = this.authId
    )
}