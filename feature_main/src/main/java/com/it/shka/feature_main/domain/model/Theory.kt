package com.it.shka.feature_main.domain.model

data class Theory(
    val id: Int,
    val topic: String,
    val title: String,
    val status: Boolean,
    val description: List<String>,
    val options: List<String>,
    val correct_option: Int
)