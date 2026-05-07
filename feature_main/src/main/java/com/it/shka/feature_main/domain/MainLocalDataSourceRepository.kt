package com.it.shka.feature_main.domain

import com.it.shka.feature_main.domain.model.Courses

interface MainLocalDataSourceRepository {
    suspend fun getFavoritesCourses(): List<Courses>
    suspend fun setFavoritesCourses(courses: Courses): Result<Unit>
    suspend fun deleteCoursesId(id: Int): Result<Unit>
}