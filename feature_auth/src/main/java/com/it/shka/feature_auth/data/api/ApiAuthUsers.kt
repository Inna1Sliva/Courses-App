package com.it.shka.feature_auth.data.api

import com.it.shka.feature_auth.domain.model.RegisterRequest
import com.it.shka.feature_auth.domain.model.RegisterResponse
import com.it.shka.feature_auth.domain.model.UsersResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiAuthUsers {
    @POST("register")
 suspend fun registerUser(@Body user: RegisterRequest) : RegisterResponse
    @GET("/api/users")
 suspend fun getUsersEmail(): List<UsersResponse>

}