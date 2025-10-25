package com.it.shka.feature_main.data.mapper

import com.it.shka.core.database.data.entity.CoursesEntity
import com.it.shka.feature_main.data.model.CoursesDto
import com.it.shka.feature_main.data.model.PageDto
import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.Page


fun PageDto.toDomainPage(): Page{
    return Page(
    data = this.data.toDomainCourses(),
    first = this.first,
    items =this.items,
    last = this.last,
    next = this.next,
    pages = this.pages
   )
}

fun List<CoursesDto>.toDomainCourses(): List<Courses> {
    return this.map { coursesDto ->
        Courses(
            id = coursesDto.id,
            categori = coursesDto.categori,
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

