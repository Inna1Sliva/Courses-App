package com.it.shka.feature_onboarding.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userId")
data class UserIdEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val authId: String?
)
