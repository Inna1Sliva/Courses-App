package com.it.shka.feature_main.data.model



data class PageDto(
    val page: Int,
    val limit: Int,
    val totalCourses: Int,
    val totalPages: Int,
    val hasNextPage: Boolean,
    val hasPrevPage: Boolean,
    val data: List<CoursesDto>
)