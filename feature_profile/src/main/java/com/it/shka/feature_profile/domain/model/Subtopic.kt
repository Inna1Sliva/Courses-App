package com.it.shka.feature_profile.domain.model

data class Subtopic(
    val id: Int,
    val subtopic_id: String,
    var status_id: Boolean,
    var status: Boolean,
    val theory: List<Theory>,
    val title: String
)