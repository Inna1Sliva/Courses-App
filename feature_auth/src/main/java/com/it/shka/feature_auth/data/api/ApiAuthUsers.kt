package com.it.shka.feature_auth.data.api

import com.it.shka.feature_auth.data.model.AuthStateResult
import com.it.shka.feature_auth.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiAuthUsers {

  //  @GET("/users")
 // fun getCourses(): Call<List<Courses>>
  @POST("/users")
  fun registerUser(@Body user: User): Call<AuthStateResult>
  @GET("/users")
  fun checkEmail(): Call<List<User>>

}