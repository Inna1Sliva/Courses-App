package com.it.shka.feature_main.presentation.mapper

import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.presentation.model.CoursesModel


fun List<Courses>.toDomain(favoriteIds: Set<Int>): List<CoursesModel> {
    return this.map {
        CoursesModel(
        hasLike =favoriteIds.contains(it.id),
        id =it.id,
        price = it.price,
        publishDate = it.publishDate,
        rate = it.rate,
        startDate = it.startDate,
        text = it.text,
        title = it.title,
        image = it.image,
        destination = it.destination,
        categori = it.categori
    )  }
    }
fun CoursesModel.toCoursesDomain(): Courses {
    return Courses(
        id = this.id,
        categori = this.categori,
        title = this.title,
        text = this.text,
        price = this.price,
        rate = this.rate,
        startDate = this.startDate,
        hasLike = this.hasLike,
        image = this.image,
        publishDate = this.publishDate,
        destination = this.destination
    )
}
    fun List<Courses>.toCourses(): List<CoursesModel> {
        return this.map {courses->
            CoursesModel(
            id = courses.id,
            categori = courses.categori,
            title = courses.title,
            text = courses.text,
            price = courses.price,
            rate = courses.rate,
            startDate = courses.startDate,
            hasLike = true,
            image = courses.image,
            publishDate = courses.publishDate,
            destination = courses.destination
        ) }
}

