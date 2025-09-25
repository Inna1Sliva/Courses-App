package com.it.shka.feature_auth.data

import com.it.shka.feature_auth.data.database.entity.UserIDEntity
import com.it.shka.feature_auth.data.model.User

fun User.toDataEntity(): UserIDEntity {
    return UserIDEntity(
        id = null,
        idUser = this.id,
        email = this.email,
        password = this.password
    )
}