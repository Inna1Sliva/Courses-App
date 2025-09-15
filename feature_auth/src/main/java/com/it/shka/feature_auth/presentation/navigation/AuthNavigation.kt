package com.it.shka.feature_auth.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_auth.presentation.screens.ScreenSignIn
import com.it.shka.feature_auth.presentation.screens.ScreenSignUp
import com.it.shka.feature_auth.presentation.navigation.rout.RouteAuthScreens

@Composable
fun AuthNavigation(){
    val  NavHostController = rememberNavController()
    NavHost(
        navController = NavHostController,
        startDestination = RouteAuthScreens.ScreenSignUp.rout
    ){
        composable(RouteAuthScreens.ScreenSignUp.rout) {
            ScreenSignUp(NavHostController)
        }
        composable(RouteAuthScreens.ScreenSignIn.rout) {
            ScreenSignIn()
        }
    }
}