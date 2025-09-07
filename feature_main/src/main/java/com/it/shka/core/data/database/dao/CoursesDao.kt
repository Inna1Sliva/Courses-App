package com.it.shka.core.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.it.shka.core.data.database.entity.CoursesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoursesDao {
    @Query("SELECT * FROM courses")
    suspend fun getAllCourses():List<CoursesEntity>
    @Query("SELECT COUNT(*) FROM courses")
    fun getCount(): Flow<Int>
    @Insert
    suspend fun insertCourses(coursesEntity: CoursesEntity)
    @Query("DELETE FROM courses WHERE id = :coursId")
    suspend fun deleteCoursesId(coursId: Int)
}