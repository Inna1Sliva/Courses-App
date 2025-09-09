package com.it.shka.feature_onboarding.presentation.route

sealed class RouteOnboarding(val rout: String) {
    object ScreenOnboardingStart: RouteOnboarding(START_ONBOARDING)
    object ScreenMain: RouteOnboarding(NEW_USER_ONBOARDING)
    object ScreenAuthUser: RouteOnboarding(NEW_USER_AUTH)

    companion object{
        private const val START_ONBOARDING = "start_onboarding"
        private const val NEW_USER_ONBOARDING ="new_user-onboarding"
        private const val NEW_USER_AUTH ="new_user-auth"

    }
}
