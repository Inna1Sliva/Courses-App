package com.it.shka.feature_onboarding.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.feature_onboarding.data.database.dao.UserIdDao
import com.it.shka.feature_onboarding.data.database.entity.UserIdEntity

@Database(entities = [UserIdEntity::class], version = 2)
abstract class AppUserDatabase: RoomDatabase() {
    abstract fun userIdDao(): UserIdDao
}