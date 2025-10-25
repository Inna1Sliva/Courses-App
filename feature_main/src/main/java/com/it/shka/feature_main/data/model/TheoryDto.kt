package com.it.shka.feature_main.data.model

data class TheoryDto(
    val id: Int,
    val topic: String,
    val title: String,
    val status: Boolean,
    val description: List<String>,
    val options: List<String>,
    val correct_option: Int
)