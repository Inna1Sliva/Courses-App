package com.it.shka.feature_onboarding.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.feature_onboarding.data.dao.UserIdDao
@Database(entities = [UserIdEntity::class], version = 2)
abstract class AppUserDatabase: RoomDatabase() {
    abstract fun userIdDao(): UserIdDao


}