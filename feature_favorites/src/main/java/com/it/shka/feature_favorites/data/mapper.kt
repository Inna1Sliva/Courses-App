package com.it.shka.feature_favorites.data

import com.it.shka.core.data.entity.CoursesEntity
import com.it.shka.feature_favorites.domain.model.Courses

fun List<CoursesEntity>.toDomainCourses(): List<Courses> {
    return this.map { coursesDto ->
        Courses(
            id = coursesDto.id,
            category = coursesDto.category,
            title = coursesDto.title,
            text = coursesDto.text,
            price = coursesDto.price,
            rate = coursesDto.rate,
            startDate = coursesDto.startDate,
            hasLike = coursesDto.hasLike,
            image = coursesDto.image,
            publishDate = coursesDto.publishDate,
            destination = coursesDto.destination
        )

    }
}