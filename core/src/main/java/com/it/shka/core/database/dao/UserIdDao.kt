package com.it.shka.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.it.shka.core.database.entity.UserIdEntity

@Dao
interface UserIdDao {
    @Query("SELECT COUNT(*) FROM userId" )
    suspend fun getUserId(): Int
    @Insert
    suspend fun setUserId(userId: UserIdEntity)
}