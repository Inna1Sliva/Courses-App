package com.it.shka.feature_auth.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.it.shka.feature_auth.data.database.entity.UserIDEntity

@Dao
interface UserIdDAO {
    @Insert
    suspend fun setUserId(userId: UserIDEntity)
}