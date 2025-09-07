package com.it.shka.core.data.api

import com.it.shka.core.data.model.CoursesDto
import com.it.shka.core.data.model.PageDto
import com.it.shka.core.domain.model.Page

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiMainCourses {

   @GET("/courses_page")
 suspend fun getCourses(@Query("_page") page: Int, @Query("_per_page") perPage: Int =10 ): PageDto
    @GET("/cache_data")
    fun getCacheData(): Call<List<CoursesDto>>
   // @POST("/cache_data")
   // fun setCacheData(@Body courses: CoursesDto): Call<CacheState>
//

}