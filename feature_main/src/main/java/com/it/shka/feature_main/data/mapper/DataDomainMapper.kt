package com.it.shka.feature_main.data.mapper

import com.it.shka.core.data.entity.CoursesEntity

import com.it.shka.feature_main.domain.model.Courses


fun List<CoursesEntity>.toDomainDataCourses(): List<Courses> {
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

fun Courses.toDataDomainCourses(favoriteIds: Set<Int>): Courses {
    return Courses(
            id = id,
            category = category,
            title = title,
            text = text,
            price = price,
            rate = rate,
            startDate = startDate,
            hasLike = favoriteIds.contains(id),
            image = image,
            publishDate = publishDate,
            destination = destination
        )
    }



fun Courses.toDomainDataCourses(): CoursesEntity =
    CoursesEntity(
        hasLike = true,
        id = id,
        price = price,
        publishDate = publishDate,
        rate = rate,
        startDate = startDate,
        text = text,
        title = title,
        image = image,
        destination = destination,
        category = category
    )

fun List<Courses>.toDomain(favoriteIds: Set<Int>): List<Courses> {
    return this.map {
        Courses(
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
            category = it.category
        )  }
}
