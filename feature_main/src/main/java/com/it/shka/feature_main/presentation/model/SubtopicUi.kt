package com.it.shka.feature_main.presentation.model


data class SubtopicUi(
    val id: Int,
    val subtopic_id: String,
    var status_id: Boolean,
    var status: Boolean,
    val theory: List<TheoryUi>,
    val title: String
)