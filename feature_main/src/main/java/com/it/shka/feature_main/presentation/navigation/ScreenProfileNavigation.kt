package com.it.shka.feature_main.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.presentation.route.RoutScreenProfile
import com.it.shka.feature_main.presentation.screens.profileinfo.MainProfileViewModel
import com.it.shka.feature_main.presentation.screens.profileinfo.ScreenCourse
import com.it.shka.feature_main.presentation.screens.profileinfo.ScreenProfile

@Composable
fun ScreenProfileNavigation(){
val navController = rememberNavController()
    val viewModel = hiltViewModel<MainProfileViewModel>()
    NavHost(
        navController = navController,
        startDestination = RoutScreenProfile.ScreenProfile.rout
    ){
        composable(RoutScreenProfile.ScreenProfile.rout){
            ScreenProfile(viewModel,navController)
        }
        composable(RoutScreenProfile.ScreenCourse.rout){
            ScreenCourse(viewModel)
        }
    }
}