package com.it.shka.feature_main.presentation.model


data class CourseUi(
    val id: Int,
    val main_topic: String,
    var status: Boolean,
    val subtopics: List<SubtopicUi>
)