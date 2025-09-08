package com.it.shka.feature_onboarding.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.it.shka.feature_onboarding.data.database.entity.UserIdEntity

@Dao
interface UserIdDao {
    @Query("SELECT * FROM userId" )
    suspend fun getUserId(): UserIdEntity?
}