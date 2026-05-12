package com.it.shka.feature_onboarding.data.mapper

import com.it.shka.core.data.entity.UserTokenEntity
import com.it.shka.feature_onboarding.domain.model.UserToken

fun UserTokenEntity.toDomainUserId():UserToken{
   return UserToken(
      token = this.authId
  )
}