package com.it.shka.feature_main.presentation.model

data class CoursesModel(
    val id: Int,
    val categori: String,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    var hasLike: Boolean,
    val image: String,
    val publishDate: String,
    val destination: String
)