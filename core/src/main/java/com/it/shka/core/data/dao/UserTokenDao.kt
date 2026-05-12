package com.it.shka.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.it.shka.core.data.entity.UserTokenEntity

@Dao
interface UserTokenDao {
    @Query("SELECT * FROM courses" )
    suspend fun getUserToken(): UserTokenEntity
    @Insert
    suspend fun setUserToken(userId: UserTokenEntity)
}