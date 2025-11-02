package com.it.shka.feature_main.domain.model

data class Course(
    val id: Int,
    val main_topic: String,
    val subtopics: List<Subtopic>
)