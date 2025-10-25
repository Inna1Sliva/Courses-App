package com.it.shka.feature_main.domain

import com.it.shka.feature_main.domain.model.CoursesProfile

interface ProfileUserRepository {
    suspend fun getCoursesProfile(): List<CoursesProfile>
}