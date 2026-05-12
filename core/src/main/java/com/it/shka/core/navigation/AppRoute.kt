package com.it.shka.core.navigation

import kotlinx.serialization.Serializable

sealed interface AppRoute
@Serializable object AppContent: AppRoute
@Serializable object MainScreen : AppRoute
@Serializable object OnboardingScreen: AppRoute
@Serializable object ScreenSignUp: AppRoute
@Serializable object ScreenSignIn: AppRoute
@Serializable object FavoritesScreen : AppRoute
@Serializable object AccountScreen : AppRoute
@Serializable object AccountScreenCourses: AppRoute