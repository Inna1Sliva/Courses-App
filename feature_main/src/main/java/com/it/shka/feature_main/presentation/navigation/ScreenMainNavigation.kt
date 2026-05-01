package com.it.shka.feature_main.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.navigation.MainScreen
import com.it.shka.core.navigation.MainScreenDetails
import com.it.shka.feature_main.presentation.screens.coursesinfo.ScreenMain
import com.it.shka.feature_main.presentation.screens.coursesinfo.ScreenMainDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMainNavigation( scrollBehavior: TopAppBarScrollBehavior){
    val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreen
    ){
        composable <MainScreen>{
            ScreenMain(navController, scrollBehavior)
        }
        composable<MainScreenDetails>{
            ScreenMainDetails(navController)
        }
    }
}