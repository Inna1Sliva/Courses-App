package com.it.shka.feature_onboarding.data.database.mapper

import com.it.shka.feature_onboarding.data.database.entity.UserIdEntity
import com.it.shka.feature_onboarding.domain.model.UserId
import com.it.shka.feature_onboarding.presentation.model.UserIdUi

fun UserIdEntity.toDomainUserId():UserId{
    return UserId(
        authId = this.authId
    )
}