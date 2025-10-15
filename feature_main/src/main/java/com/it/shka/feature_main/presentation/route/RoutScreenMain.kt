package com.it.shka.feature_main.presentation.route

sealed class RoutScreenMain(val rout: String) {
    object ScreenMain: RoutScreenMain("Главная")
    object ScreenMainDetail: RoutScreenMain("detail")
}