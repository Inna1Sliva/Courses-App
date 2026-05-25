package com.it.shka.feature_bottom_nav.domain.model

data class UserResponse(
    val id: String,
    val username: String,
    val password: String,
    val email: String,
    val token: String,
    val createdAt: String,
    val lastLogin: String,
    val notification: Notification,

    )