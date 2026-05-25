package com.it.shka.ourses_app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.navigation.AppContent
import com.it.shka.core.navigation.ScreenSignUp
import com.it.shka.core.navigation.OnboardingScreen
import com.it.shka.feature_auth.presentation.navigation.AuthNavigation
import com.it.shka.feature_onboarding.presentation.navigation.NavigationScreenOnboarding
import com.it.shka.ourses_app.presentation.AppMainContent

@Composable
fun AppNavigation(){
    val navAppNavigationController = rememberNavController()
    NavHost(
        navController = navAppNavigationController,
        startDestination = OnboardingScreen
    ){
        composable<OnboardingScreen>{
        NavigationScreenOnboarding(navAppNavigationController)
        }
       composable<ScreenSignUp>{
           AuthNavigation(navAppNavigationController)
       }
        composable<AppContent> {
            AppMainContent()
        }
    }
}