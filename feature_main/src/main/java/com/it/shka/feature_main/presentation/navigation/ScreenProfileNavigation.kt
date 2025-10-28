package com.it.shka.feature_main.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.presentation.route.RoutScreenProfile
import com.it.shka.feature_main.presentation.screens.profileinfo.ScreenCourse
import com.it.shka.feature_main.presentation.screens.profileinfo.ScreenProfile

@Composable
fun ScreenProfileNavigation(){
val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RoutScreenProfile.ScreenProfile.rout
    ){
        composable(RoutScreenProfile.ScreenProfile.rout){
            ScreenProfile(navController)
        }
        composable(RoutScreenProfile.ScreenCourse.rout){
            ScreenCourse()
        }
    }
}