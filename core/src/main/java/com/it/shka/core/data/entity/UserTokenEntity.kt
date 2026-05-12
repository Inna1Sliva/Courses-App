package com.it.shka.core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userId")
data class UserTokenEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val token: String?

)
