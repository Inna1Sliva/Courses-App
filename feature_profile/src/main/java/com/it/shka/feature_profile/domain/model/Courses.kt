package com.it.shka.feature_profile.domain.model

data class Courses(
    val id: Int,
    val main_topic: String,
    val subtopics: List<Subtopic>
)