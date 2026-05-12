package com.it.shka.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core.data.dao.CoursesDao
import com.it.shka.core.data.dao.UserTokenDao
import com.it.shka.core.data.entity.CoursesEntity
import com.it.shka.core.data.entity.UserTokenEntity

@Database(entities = [CoursesEntity::class, UserTokenEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun coursesDao(): CoursesDao
    abstract fun userIdDao(): UserTokenDao




}