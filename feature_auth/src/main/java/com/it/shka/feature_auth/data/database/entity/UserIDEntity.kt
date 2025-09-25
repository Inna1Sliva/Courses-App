package com.it.shka.feature_auth.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userId")
data class UserIDEntity(
   @PrimaryKey(autoGenerate = true)
   val id : Int?,
    val idUser: String?,
    val email: String?,
    val password: String?
)