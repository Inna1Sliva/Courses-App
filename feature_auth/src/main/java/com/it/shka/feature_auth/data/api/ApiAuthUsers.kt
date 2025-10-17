package com.it.shka.feature_auth.data.api

import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.domain.Result
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiAuthUsers {
    @POST("/users")
 suspend fun registerUser(@Body user: User) : Result
    @GET("/users")
 suspend fun checkEmail(): List<User>

}