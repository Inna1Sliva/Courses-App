package com.it.shka.feature_profile.data.mapper

import com.it.shka.core.data.entity.UserTokenEntity
import com.it.shka.feature_profile.domain.model.Token

fun UserTokenEntity.toDomain(): Token{
    return Token(
       token = token
    )
}
