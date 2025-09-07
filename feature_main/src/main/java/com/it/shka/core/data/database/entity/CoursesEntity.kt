package com.it.shka.core.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class CoursesEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "categori")
    val categori: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "rate")
    val rate: String,
    @ColumnInfo(name = "startDate")
    val startDate: String,
    @ColumnInfo(name = "hasLike")
    val hasLike: Boolean,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "publishDate")
    val publishDate: String,
    @ColumnInfo(name = "destination")
    val destination: String
)
