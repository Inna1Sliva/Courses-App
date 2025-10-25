package com.it.shka.feature_main.presentation.model


data class SubtopicUi(
    val id: Int,
    val subtopic_id: String,
    val theory: List<TheoryUi>,
    val title: String
)