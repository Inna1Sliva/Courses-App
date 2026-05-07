package com.it.shka.feature_main.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.it.shka.core.navigation.MainScreen
import com.it.shka.feature_main.presentation.screens.coursesinfo.ScreenMain
import com.it.shka.feature_main.presentation.screens.coursesinfodetails.ScreenMainDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMainNavigation(){
    val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreen
    ){
        composable <MainScreen>{
            ScreenMain(navController)
        }
        composable("MainScreenDetails/{coursesId}", arguments = listOf(
            navArgument("coursesId"){type = NavType.StringType}
        )){ backStackEntry->
            val coursesId = backStackEntry.arguments?.getString("coursesId") ?: ""
            ScreenMainDetails(coursesId, navController)
        }
    }
}