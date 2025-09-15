package com.it.shka.feature_auth.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.feature_auth.data.database.dao.UserIdDAO
import com.it.shka.feature_auth.data.database.entity.UserIDEntity

@Database(entities = [UserIDEntity::class], version = 2)
abstract class AppUserIdDatabase : RoomDatabase(){
    abstract fun userIdDao(): UserIdDAO
}