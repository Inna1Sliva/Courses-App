package com.it.shka.core.data.database

import com.it.shka.core.data.database.entity.CoursesEntity
import com.it.shka.core.domain.model.Courses

fun Courses.toDomainCourses(): CoursesEntity =
    CoursesEntity(
        hasLike = hasLike,
        id = id,
        price = price,
        publishDate = publishDate,
        rate = rate,
        startDate = startDate,
        text = text,
        title = title,
        image = image,
        destination = destination,
        categori = categori
    )
fun List<CoursesEntity>.toCourses(): List<Courses>{
    return this.map {coursesEntity->
        Courses(
            id = coursesEntity.id,
            categori = coursesEntity.categori,
            title=  coursesEntity.title,
            text = coursesEntity.text,
            price= coursesEntity.price,
            rate =coursesEntity.rate,
            startDate = coursesEntity.startDate,
            hasLike= coursesEntity.hasLike,
            image = coursesEntity.image,
            publishDate =coursesEntity.publishDate,
            destination =coursesEntity.destination
        )

    }


}