package com.it.shka.feature_profile.domain.model

data class UserSettings(
    val theme: String,
    val language: String,
    val notifications: NotificationSettings
)
