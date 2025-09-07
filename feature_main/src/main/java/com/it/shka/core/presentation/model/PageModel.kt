package com.it.shka.core.presentation.model

import com.it.shka.core.data.model.CoursesDto

data class PageModel(
    val data: List<CoursesDto>,
    val first: Int,
    val items: Int,
    val last: Int,
    val next: Int,
    val pages: Int,
    val prev: Any
)