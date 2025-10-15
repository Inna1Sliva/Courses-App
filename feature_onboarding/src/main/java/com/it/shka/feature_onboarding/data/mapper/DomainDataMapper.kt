package com.it.shka.feature_onboarding.data.mapper

import com.it.shka.core.database.entity.UserIdEntity
import com.it.shka.feature_onboarding.domain.model.UserId

fun UserIdEntity.toDomainUserId():UserId{
   return UserId(
       authId = this.authId
  )
}