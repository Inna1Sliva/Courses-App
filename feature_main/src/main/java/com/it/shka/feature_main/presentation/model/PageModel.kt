package com.it.shka.feature_main.presentation.model

import com.it.shka.feature_main.data.model.CoursesDto

data class PageModel(
    val data: List<CoursesDto>,
    val first: Int,
    val items: Int,
    val last: Int,
    val next: Int,
    val pages: Int,
    val prev: Any
)