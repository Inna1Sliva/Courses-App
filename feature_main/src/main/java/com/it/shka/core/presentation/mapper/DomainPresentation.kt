package com.it.shka.core.presentation.mapper

import com.it.shka.core.data.database.entity.CoursesEntity
import com.it.shka.core.domain.model.Courses
import com.it.shka.core.domain.model.Page
import com.it.shka.core.presentation.model.CoursesModel
import com.it.shka.core.presentation.model.PageModel

fun PageModel.toDomainPage(): Page{
    val courses = this.data.map {coursesDto->
        Courses(
            hasLike = coursesDto.hasLike,
            id = coursesDto.id,
            price = coursesDto.price,
            publishDate = coursesDto.publishDate,
            rate = coursesDto.rate,
            startDate = coursesDto.startDate,
            text = coursesDto.text,
            title = coursesDto.title,
            image = coursesDto.image,
            destination = coursesDto.destination,
            categori = coursesDto.categori
        )
    }
    return Page(
        data = courses,
        first = this.first,
        items = this.items,
        last = this.last,
        next = this.next,
        pages = this.pages
    )
}

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

