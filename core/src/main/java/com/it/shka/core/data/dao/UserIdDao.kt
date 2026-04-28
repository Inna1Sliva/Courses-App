package com.it.shka.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.it.shka.core.data.entity.UserIdEntity

@Dao
interface UserIdDao {
    @Query("SELECT COUNT(*) FROM userId" )
    suspend fun getUserId(): Int
    @Insert
    suspend fun setUserId(userId: UserIdEntity)
}