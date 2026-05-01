package com.it.shka.feature_profile.data.api

import com.it.shka.feature_profile.domain.model.DataCourses
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiProfileCourses {
    @GET("api/user_courses")
    suspend fun getListCourse(): List<DataCourses>
    @PUT("api/courses/{id}")
    suspend fun setTheoryCourse(@Path("id") id: Int, @Body dataCourses: DataCourses?)
}