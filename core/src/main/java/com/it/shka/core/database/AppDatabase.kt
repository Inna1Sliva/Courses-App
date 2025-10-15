package com.it.shka.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core.database.dao.CoursesDao
import com.it.shka.core.database.dao.UserIdDao
import com.it.shka.core.database.entity.CoursesEntity
import com.it.shka.core.database.entity.UserIdEntity


@Database(entities = [CoursesEntity::class, UserIdEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun coursesDao(): CoursesDao
    abstract fun userIdDao(): UserIdDao




}