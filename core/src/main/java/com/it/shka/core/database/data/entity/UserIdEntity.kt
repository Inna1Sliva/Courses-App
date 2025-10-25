package com.it.shka.core.database.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userId")
data class UserIdEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val authId: String?,
    val email: String?,
    val password: String?
)
