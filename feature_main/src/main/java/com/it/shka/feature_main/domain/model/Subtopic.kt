package com.it.shka.feature_main.domain.model

data class Subtopic(
    val id: Int,
    val subtopic_id: String,
    val status_id: Boolean,
    val status: Boolean,
    val theory: List<Theory>,
    val title: String
)