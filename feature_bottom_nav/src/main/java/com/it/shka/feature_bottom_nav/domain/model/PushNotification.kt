package com.it.shka.feature_bottom_nav.domain.model

data class PushNotification(
    val id: String,
    val createdAt: String,
    val lastLogin: String,
    val status: Boolean,
    val text: String
)
