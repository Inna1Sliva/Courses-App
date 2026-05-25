package com.it.shka.feature_profile.domain.model

data class UserResponse(
    val id: String,
    val username: String,
    val password: String,
    val email: String,
    val token: String,
    val createdAt: String,
    val lastLogin: String,
    val settings: UserSettings,
    val supportChat: SupportChat,
    val notification: Notification,
    val courses: List<DataCourses>
)
