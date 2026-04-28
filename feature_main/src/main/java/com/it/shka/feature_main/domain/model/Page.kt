package com.it.shka.feature_main.domain.model


data class Page(
    val page: Int,
    val limit: Int,
    val totalCourses: Int,
    val totalPages: Int,
    val hasNextPage: Boolean,
    val hasPrevPage: Boolean,
    val data: List<Courses>



)