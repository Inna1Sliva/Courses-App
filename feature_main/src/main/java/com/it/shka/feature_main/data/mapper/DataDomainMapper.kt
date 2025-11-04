package com.it.shka.feature_main.data.mapper

import com.it.shka.core.database.data.entity.CoursesEntity
import com.it.shka.feature_main.data.model.CourseDto
import com.it.shka.feature_main.data.model.CoursesDto
import com.it.shka.feature_main.data.model.CoursesProfileDto
import com.it.shka.feature_main.data.model.PageDto
import com.it.shka.feature_main.data.model.SubtopicDto
import com.it.shka.feature_main.data.model.TheoryDto
import com.it.shka.feature_main.domain.model.Course
import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.CoursesProfile
import com.it.shka.feature_main.domain.model.Page
import com.it.shka.feature_main.domain.model.Subtopic
import com.it.shka.feature_main.domain.model.Theory


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
fun CoursesProfileDto.toDomainDataCoursesProfile(): CoursesProfile{
    return CoursesProfile(
        id = this.id,
        category = this.category,
        title = this.title,
        text = this.text,
        price = this.price,
        rate = this.rate,
        startDate = this.startDate,
        hasLike = this.hasLike,
        image = this.image,
        publishDate = this.publishDate,
        destination = this.destination,
        cours = this.cours.toDomainDataCourse()
    )
}
fun CoursesProfile.toDomainDataCoursesProfileDto(): CoursesProfileDto{
    return CoursesProfileDto(
        id = this.id,
        category = this.category,
        title = this.title,
        text = this.text,
        price = this.price,
        rate = this.rate,
        startDate = this.startDate,
        hasLike = this.hasLike,
        image = this.image,
        publishDate = this.publishDate,
        destination = this.destination,
        cours = this.cours.toDomainDataCourseDto()
    )
}
fun List<Course>.toDomainDataCourseDto(): List<CourseDto>{
    return this.map { course ->
        CourseDto(
            id = course.id,
            main_topic = course.main_topic,
            subtopics = course.subtopics.toDomainSubtopicDto()
        )
    }
}
fun List<Subtopic>.toDomainSubtopicDto(): List<SubtopicDto>{
    return this.map {subtopic ->
        SubtopicDto(
            id = subtopic.id,
            subtopic_id = subtopic.subtopic_id,
            status_id = subtopic.status_id,
            status = subtopic.status,
            title = subtopic.title,
            theory = subtopic.theory.toDomainTheoryDto()
        )
    }
}
fun List<Theory>.toDomainTheoryDto(): List<TheoryDto>{
    return this.map { theory ->
        TheoryDto(
            id = theory.id,
            topic = theory.topic,
            title = theory.title,
            status = theory.status,
            description = theory.description,
            options = theory.options,
            correct_option = theory.correct_option

        )
    }
}
fun List<CoursesProfileDto>.toDomainCoursesProfile(): List<CoursesProfile>{
    return this.map {
        CoursesProfile(
            id = it.id,
            category = it.category,
            title = it.title,
            text = it.text,
            price = it.price,
            rate= it.rate,
            startDate = it.startDate,
            hasLike = it.hasLike,
            image = it.image,
            publishDate = it.publishDate,
            destination = it.destination,
            cours = it.cours.toDomainDataCourse()
        )
    }
}

fun List<CourseDto>.toDomainDataCourse(): List<Course>{
    return this.map { courseDto ->
        Course(
            id = courseDto.id,
            main_topic = courseDto.main_topic,
            subtopics = courseDto.subtopics.toDomainSubtopic()
        )
    }
}
fun List<SubtopicDto>.toDomainSubtopic(): List<Subtopic>{
    return this.map {subtopicDto ->
        Subtopic(
            id = subtopicDto.id,
            subtopic_id = subtopicDto.subtopic_id,
            status_id = subtopicDto.status_id,
            status = subtopicDto.status,
            title = subtopicDto.title,
            theory = subtopicDto.theory.toDomainTheory()
        )
    }
}
fun List<TheoryDto>.toDomainTheory(): List<Theory>{
    return this.map { theoryDto ->
        Theory(
            id = theoryDto.id,
            topic = theoryDto.topic,
            title = theoryDto.title,
            status = theoryDto.status,
            description = theoryDto.description,
            options = theoryDto.options,
            correct_option = theoryDto.correct_option

        )
    }
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

