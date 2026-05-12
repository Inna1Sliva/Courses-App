package com.it.shka.feature_onboarding.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.navigation.OnboardingScreen
import com.it.shka.feature_onboarding.presentation.screens.ScreenOnboarding

@Composable
fun NavigationScreenOnboarding(navAppMain: NavHostController){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OnboardingScreen
    ){
        composable<OnboardingScreen> {
            ScreenOnboarding(navAppMain, navController )
        }
    }
}