package com.it.shka.feature_main.domain.model

data class CoursesProfile(
    val id: Int,
    val category: String,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val image: String,
    val publishDate: String,
    val destination: List<String>,
    val cours: List<Course>
)