package com.it.shka.feature_main.presentation.route



sealed class RoutScreenProfile(val rout : String) {
    object ScreenProfile: RoutScreenProfile("Profile")
    object ScreenCourse: RoutScreenProfile("Course")
}