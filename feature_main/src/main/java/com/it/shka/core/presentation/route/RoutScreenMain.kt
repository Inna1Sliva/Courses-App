package com.it.shka.core.presentation.route

sealed class RoutScreenMain(val rout: String) {
    object ScreenMain: RoutScreenMain("Главная")
    object ScreenMainDetail: RoutScreenMain("detail")
}