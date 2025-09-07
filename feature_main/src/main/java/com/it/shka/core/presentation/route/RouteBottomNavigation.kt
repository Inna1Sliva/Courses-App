package com.it.shka.core.presentation.route

sealed class RouteBottomNavigation( val route: String) {
    object ScreenMain: RouteBottomNavigation("Главная")
    object ScreenFavorits: RouteBottomNavigation("Избранное")
    object ScreenProfile: RouteBottomNavigation("Аккаунт")

}