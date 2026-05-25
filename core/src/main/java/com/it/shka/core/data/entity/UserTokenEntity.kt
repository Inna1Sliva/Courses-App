package com.it.shka.core.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userToken")
data class UserTokenEntity(
    @PrimaryKey
    @ColumnInfo(name = "token")
    val token: String

)
