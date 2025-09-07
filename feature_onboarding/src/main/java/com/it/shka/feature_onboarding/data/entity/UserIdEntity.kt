package com.it.shka.feature_onboarding.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userId")
data class UserIdEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String
)
