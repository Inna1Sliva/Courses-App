package com.it.shka.feature_main.domain.model


data class Page(
    val data: List<Courses>,
    val first: Int,
    val items: Int,
    val last: Int,
    val next: Int,
    val pages: Int

)