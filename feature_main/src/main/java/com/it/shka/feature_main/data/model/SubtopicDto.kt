package com.it.shka.feature_main.data.model


data class SubtopicDto(
    val id: Int,
    val subtopic_id: String,
    val theory: List<TheoryDto>,
    val title: String
)