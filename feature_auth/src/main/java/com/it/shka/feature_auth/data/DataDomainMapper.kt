package com.it.shka.feature_auth.data

import com.it.shka.core.data.entity.UserTokenEntity
import com.it.shka.feature_auth.data.model.User

fun User.toDataEntity(): UserTokenEntity {
    return UserTokenEntity(
        id = null,
        authId = this.id,
        email = this.email,
        password = this.password
    )
}