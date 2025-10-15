package com.it.shka.feature_auth.data

import com.it.shka.core.database.entity.UserIdEntity
import com.it.shka.feature_auth.data.model.User

fun User.toDataEntity(): UserIdEntity {
    return UserIdEntity(
        id = null,
        authId = this.id,
        email = this.email,
        password = this.password
    )
}