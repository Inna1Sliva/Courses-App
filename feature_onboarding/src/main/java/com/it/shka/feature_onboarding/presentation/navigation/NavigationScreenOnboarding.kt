package com.it.shka.feature_onboarding.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_onboarding.presentation.screens.ScreenOnboarding
import com.it.shka.feature_onboarding.presentation.route.RouteOnboarding

@Composable
fun NavigationScreenOnboarding(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouteOnboarding.ScreenOnboardingStart.rout
    ){
        composable(RouteOnboarding.ScreenOnboardingStart.rout) {
            ScreenOnboarding()
        }
    }
}