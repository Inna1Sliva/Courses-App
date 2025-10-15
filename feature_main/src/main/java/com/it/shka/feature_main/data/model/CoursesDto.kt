package com.it.shka.feature_main.data.model

data class CoursesDto(
    val id: Int,
    val categori: String,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val image: String,
    val publishDate: String,
    val destination: String
)