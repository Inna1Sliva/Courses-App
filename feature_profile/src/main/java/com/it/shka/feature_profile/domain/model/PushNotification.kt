package com.it.shka.feature_profile.domain.model

data class PushNotification(
    val id: String,
    val createdAt: String,
    val lastLogin: String,
    val status: Boolean,
    val text: String
)
