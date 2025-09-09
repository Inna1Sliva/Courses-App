package com.it.shka.ourses_app.navigation.rout

sealed class RoutAppNavigation(val rout: String) {
    object ScreenStartOnboarding: RoutAppNavigation(START_ONBOARDING)
    object ScreenAuthUser: RoutAppNavigation(NEW_USER_AUTH)
    object ScreenMainContent: RoutAppNavigation(MAIN_CONTENT)

    companion object{
        private const val START_ONBOARDING = "start_onboarding"
        private const val NEW_USER_AUTH ="new_user-auth"
        private const val MAIN_CONTENT ="main_content"


    }
}