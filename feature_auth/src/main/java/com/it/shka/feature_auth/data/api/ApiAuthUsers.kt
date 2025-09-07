package com.it.shka.feature_auth.data.api

import com.it.shka.feature_auth.data.model.AuthState
import com.it.shka.feature_auth.data.model.Courses
import com.it.shka.feature_auth.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiAuthUsers {

  //  @GET("/users")
 // fun getCourses(): Call<List<Courses>>
  @POST("/users")
  fun registerUser(@Body user: User): Call<AuthState>
  @GET("/users")
  fun checkEmail(): Call<List<User>>

}