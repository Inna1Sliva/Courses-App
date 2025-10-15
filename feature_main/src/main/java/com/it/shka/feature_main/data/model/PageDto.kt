package com.it.shka.feature_main.data.model


data class PageDto(
    val data: List<CoursesDto>,
    val first: Int,
    val items: Int,
    val last: Int,
    val next: Int,
    val pages: Int
)