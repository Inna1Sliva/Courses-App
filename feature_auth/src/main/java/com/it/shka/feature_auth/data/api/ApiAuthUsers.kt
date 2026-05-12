package com.it.shka.feature_auth.data.api

import com.it.shka.feature_auth.data.model.User
import com.it.shka.feature_auth.domain.UserToken
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiAuthUsers {
    @POST("/register")
 suspend fun registerUser(@Body user: User) : UserToken
    @GET("/users")
 suspend fun checkEmail(): List<User>

}