package com.it.shka.core.domain.model

import android.app.ActivityManager
import com.google.gson.annotations.SerializedName

data class Courses(
    val id: Int,
    val categori: String,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val image: String,
    val publishDate: String,
    val destination: String
)