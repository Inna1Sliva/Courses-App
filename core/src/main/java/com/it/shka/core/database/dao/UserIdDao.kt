package com.it.shka.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.it.shka.core.database.entity.UserIdEntity

@Dao
interface UserIdDao {
    @Query("SELECT * FROM userId" )
    suspend fun getUserId(): UserIdEntity?
    @Insert
    suspend fun setUserId(userId: UserIdEntity)
}