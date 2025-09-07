package com.it.shka.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core.data.database.dao.CoursesDao
import com.it.shka.core.data.database.entity.CoursesEntity

@Database(entities = [CoursesEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun coursesDao(): CoursesDao

}