package com.it.shka.feature_main.presentation.mapper


import com.it.shka.feature_main.data.mapper.toDomainCourse
import com.it.shka.feature_main.data.model.CoursesProfileDto
import com.it.shka.feature_main.domain.model.Course
import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.CoursesProfile
import com.it.shka.feature_main.domain.model.Subtopic
import com.it.shka.feature_main.domain.model.Theory
import com.it.shka.feature_main.presentation.model.CourseUi
import com.it.shka.feature_main.presentation.model.CoursesModel
import com.it.shka.feature_main.presentation.model.CoursesProfileUi
import com.it.shka.feature_main.presentation.model.SubtopicUi
import com.it.shka.feature_main.presentation.model.TheoryUi
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
        cours = this.cours.toDomainCourse()
    )
}
fun CoursesProfile.toDomainDataCoursesProfile(): CoursesProfileUi{
    return CoursesProfileUi(
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
        cours = this.cours.toDomainCourses()
    )
}
fun List<CoursesProfile>.toDomainCoursesProfile(): List<CoursesProfileUi>{
    return this.map {coursesProfile ->
        CoursesProfileUi(
            id = coursesProfile.id,
            category = coursesProfile.category,
            title =coursesProfile.title,
            text = coursesProfile.text,
            price =coursesProfile.price,
            rate= coursesProfile.rate,
            startDate = coursesProfile.startDate,
            hasLike = coursesProfile.hasLike,
            image = coursesProfile.image,
            publishDate = coursesProfile.publishDate,
            destination = coursesProfile.destination,
            cours = coursesProfile.cours.toDomainCourses()
        )
    }
}
fun List<Course>.toDomainCourses(): List<CourseUi>{
    return this.map { course ->
        CourseUi(
            id = course.id,
            main_topic = course.main_topic,
            subtopics = course.subtopics.toDomainSubtopic()
        )
    }
}
fun List<Subtopic>.toDomainSubtopic(): List<SubtopicUi>{
    return this.map {subtopicDto ->
        SubtopicUi(
            id = subtopicDto.id,
            subtopic_id = subtopicDto.subtopic_id,
            status_id = subtopicDto.status_id,
            status = subtopicDto.status,
            title = subtopicDto.title,
            theory = subtopicDto.theory.toDomainTheory()
        )
    }
}
fun List<Theory>.toDomainTheory(): List<TheoryUi>{
    return this.map { theoryDto ->
        TheoryUi(
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

