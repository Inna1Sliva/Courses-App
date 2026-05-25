package com.it.shka.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.it.shka.core.data.entity.UserTokenEntity

@Dao
interface UserTokenDao {
    @Query( "SELECT COUNT(*) FROM userToken")
    suspend fun getTokenCount(): Int
    @Query("SELECT * FROM userToken")
    suspend fun getToken(): UserTokenEntity
    @Insert
    suspend fun setUserToken(userToken: UserTokenEntity)
}