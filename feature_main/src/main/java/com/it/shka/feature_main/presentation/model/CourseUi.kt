package com.it.shka.feature_main.presentation.model


data class CourseUi(
    val id: Int,
    val main_topic: String,
    val subtopics: List<SubtopicUi>
)