package com.it.shka.feature_main.data.api

import com.it.shka.feature_main.data.model.CoursesDto
import com.it.shka.feature_main.data.model.PageDto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiMainCourses {

   @GET("/courses_page")
 suspend fun getCourses(@Query("_page") page: Int, @Query("_per_page") perPage: Int =10 ): PageDto


}