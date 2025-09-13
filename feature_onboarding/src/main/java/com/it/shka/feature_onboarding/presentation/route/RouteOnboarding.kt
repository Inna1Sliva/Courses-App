package com.it.shka.feature_onboarding.presentation.route

sealed class RouteOnboarding(val rout: String) {
    object ScreenMain: RouteOnboarding(NEW_USER_ONBOARDING)
    object ScreenAuthUser: RouteOnboarding(NEW_USER_AUTH)
    object ScreenMainCourses: RouteOnboarding(MAIN_CONTENT)

    companion object{
        private const val MAIN_CONTENT = "main_content"
        private const val NEW_USER_ONBOARDING ="new_user-onboarding"
        private const val NEW_USER_AUTH ="new_user-auth"

    }
}
