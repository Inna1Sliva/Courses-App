package com.it.shka.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core.data.dao.CoursesDao
import com.it.shka.core.data.dao.UserIdDao
import com.it.shka.core.data.entity.CoursesEntity
import com.it.shka.core.data.entity.UserIdEntity

@Database(entities = [CoursesEntity::class, UserIdEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun coursesDao(): CoursesDao
    abstract fun userIdDao(): UserIdDao




}