package com.it.shka.ourses_app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.navigation.AppContent
import com.it.shka.ourses_app.presentation.AppMainContent

@Composable
fun AppNavigation(){
    val navAppNavigationController = rememberNavController()
    NavHost(
        navController = navAppNavigationController,
        startDestination = AppContent
    ){
        // composable (RoutAppNavigation.ScreenStartOnboarding.rout){
       // NavigationScreenOnboarding(navAppNavigationController)
       // }
       // composable(RoutAppNavigation.ScreenAuthUser.rout){
          //  AuthNavigation(navAppNavigationController)
       // }
        composable<AppContent> {
            AppMainContent()
        }
    }
}