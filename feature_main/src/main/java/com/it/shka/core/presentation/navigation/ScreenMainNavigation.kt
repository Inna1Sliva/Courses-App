package com.it.shka.core.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.presentation.screens.coursesinfo.ScreenMain
import com.it.shka.core.presentation.screens.coursesinfo.ScreenMainDetails
import com.it.shka.core.presentation.route.RoutScreenMain
import com.it.shka.core.presentation.route.RouteBottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMainNavigation( scrollBehavior: TopAppBarScrollBehavior){
    val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RoutScreenMain.ScreenMain.rout
    ){
        composable (RouteBottomNavigation.ScreenMain.route){
            ScreenMain(navController, scrollBehavior)
        }
        composable (RoutScreenMain.ScreenMainDetail.rout){
            ScreenMainDetails(navController)
        }
    }
}