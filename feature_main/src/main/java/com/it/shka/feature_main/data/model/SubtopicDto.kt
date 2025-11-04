package com.it.shka.feature_main.data.model


data class SubtopicDto(
    val id: Int,
    val subtopic_id: String,
    var status_id: Boolean,
    var status: Boolean,
    val theory: List<TheoryDto>,
    val title: String
)