package com.it.shka.feature_bottom_nav.presentation.model

import com.it.shka.core.navigation.AppRoute

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: AppRoute,
    val badge: Int?
)