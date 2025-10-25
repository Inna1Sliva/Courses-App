package com.it.shka.core.database.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core.database.data.dao.CoursesDao
import com.it.shka.core.database.data.dao.UserIdDao
import com.it.shka.core.database.data.entity.CoursesEntity
import com.it.shka.core.database.data.entity.UserIdEntity

@Database(entities = [CoursesEntity::class, UserIdEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun coursesDao(): CoursesDao
    abstract fun userIdDao(): UserIdDao




}