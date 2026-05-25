package com.it.shka.feature_auth.data

import com.it.shka.core.data.entity.UserTokenEntity
import com.it.shka.feature_auth.domain.model.RegisterResponse

fun RegisterResponse.toDomain(): UserTokenEntity {
    return UserTokenEntity(
        token = token
        )
}