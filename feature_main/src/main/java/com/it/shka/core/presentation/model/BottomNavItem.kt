package com.it.shka.core.presentation.model

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: String,
    val badge: Int?
)
