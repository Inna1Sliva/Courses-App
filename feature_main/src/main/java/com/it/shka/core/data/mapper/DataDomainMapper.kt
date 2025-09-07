package com.it.shka.core.data.mapper

import com.it.shka.core.data.database.entity.CoursesEntity
import com.it.shka.core.data.model.CoursesDto
import com.it.shka.core.data.model.PageDto
import com.it.shka.core.domain.model.Courses
import com.it.shka.core.domain.model.Page
import com.it.shka.core.presentation.model.CoursesModel
import kotlin.Int


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
    return this.map { coursesDto->
        Courses(
           id = coursesDto.id,
            categori = coursesDto.categori,
         title=  coursesDto.title,
         text= coursesDto.text,
        price= coursesDto.price,
        rate = coursesDto.rate,
        startDate=  coursesDto.startDate,
        hasLike= coursesDto.hasLike,
        image = coursesDto.image,
        publishDate =coursesDto.publishDate,
        destination = coursesDto.destination
        )

    }
    fun CoursesEntity.toDomainDatabase(): Courses =
        Courses(
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



}

