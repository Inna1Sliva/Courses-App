package com.it.shka.feature_main.presentation.model

data class TheoryUi(
    val id: Int,
    val topic: String,
    val title: String,
    var status: Boolean,
    val description: List<String>,
    val options: List<String>,
    val correct_option: Int
)