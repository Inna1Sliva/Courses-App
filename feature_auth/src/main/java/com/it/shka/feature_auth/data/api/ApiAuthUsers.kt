package com.it.shka.feature_auth.data.api

import com.it.shka.feature_auth.data.model.AuthStateResult
import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.domain.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiAuthUsers {

  //  @GET("/users")
 // fun getCourses(): Call<List<Courses>>
  @POST("/users")
 suspend fun registerUser(@Body user: User) : Result
  @GET("/users")
 suspend fun checkEmail(@Query("email") email: String): User

}