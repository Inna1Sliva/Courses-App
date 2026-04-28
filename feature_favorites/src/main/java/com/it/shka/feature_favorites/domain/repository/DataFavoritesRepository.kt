package com.it.shka.feature_favorites.domain.repository

import com.it.shka.feature_favorites.domain.model.Courses

interface DataFavoritesRepository {
    suspend fun getFavoritesCourses(): Result<List<Courses>>
    suspend fun deleteCoursesId(id: Int): Result<Unit>
}