package com.it.shka.feature_main.data.api

import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.domain.model.Page
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiMainCourses {
    @GET("api/courses")
    suspend fun getCourses(@Query("page") page: Int, @Query("limit") limit: Int =10, @Query("q") query: String? = null): Page
    @GET("/api/courses/{id}")
    suspend fun getCourseById(
        @Path("id") courseId: String
    ): Courses
}