package com.it.shka.ourses_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.presentation.navigation.RootNavGraphMainContent
import com.it.shka.feature_auth.presentation.navigation.AuthNavigation
import com.it.shka.feature_onboarding.presentation.navigation.NavigationScreenOnboarding
import com.it.shka.ourses_app.navigation.rout.RoutAppNavigation

@Composable
fun AppNavigation(){
    val navAppNavigationController = rememberNavController()
    NavHost(
        navController = navAppNavigationController,
        startDestination = RoutAppNavigation.ScreenStartOnboarding.rout
    ){
         composable (RoutAppNavigation.ScreenStartOnboarding.rout){
        NavigationScreenOnboarding(navAppNavigationController)
        }
        composable(RoutAppNavigation.ScreenAuthUser.rout){
            AuthNavigation(navAppNavigationController)
        }
        composable(RoutAppNavigation.ScreenMainContent.rout) {
            RootNavGraphMainContent()
        }
    }
}