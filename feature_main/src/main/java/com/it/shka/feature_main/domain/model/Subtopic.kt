package com.it.shka.feature_main.domain.model

data class Subtopic(
    val id: Int,
    val subtopic_id: String,
    val theory: List<Theory>,
    val title: String
)