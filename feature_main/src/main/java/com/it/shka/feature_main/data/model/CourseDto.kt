package com.it.shka.feature_main.data.model


data class CourseDto(
    val id: Int,
    val main_topic: String,
    val subtopics: List<SubtopicDto>
)