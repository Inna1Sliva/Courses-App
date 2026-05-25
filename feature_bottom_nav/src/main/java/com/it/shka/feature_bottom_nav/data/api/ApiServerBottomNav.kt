package com.it.shka.feature_bottom_nav.data.api

import com.it.shka.feature_bottom_nav.domain.model.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServerBottomNav {
    @GET("api/users/{token}")
    suspend fun getUser(@Path("token") token: String): UserResponse
}