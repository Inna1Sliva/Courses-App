package com.it.shka.feature_main.data.api

import com.it.shka.feature_main.data.model.CourseDto
import com.it.shka.feature_main.data.model.CoursesProfileDto
import com.it.shka.feature_main.data.model.PageDto
import com.it.shka.feature_main.domain.model.Course
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiMainCourses {
    @GET("/courses_page")
 suspend fun getCourses(@Query("_page") page: Int, @Query("_per_page") perPage: Int =10 ): PageDto
    @GET("/cours_main")
 suspend fun getListCourse(): List<CoursesProfileDto>
 @GET("/cours_main")
 suspend fun getCourseId(@Query("id") id: Int): List<CoursesProfileDto>
}