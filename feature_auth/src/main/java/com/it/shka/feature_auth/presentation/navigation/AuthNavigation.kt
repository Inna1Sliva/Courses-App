package com.it.shka.feature_auth.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.navigation.ScreenSignIn
import com.it.shka.core.navigation.ScreenSignUp
import com.it.shka.feature_auth.presentation.screens.ScreenSignIn
import com.it.shka.feature_auth.presentation.screens.signUp.ScreenSignUp

@Composable
fun AuthNavigation(appNavigation: NavHostController){
    val  authNavController = rememberNavController()
    NavHost(
        navController = authNavController,
        startDestination = ScreenSignUp
    ){
        composable<ScreenSignUp>{
            ScreenSignUp(authNavController, appNavigation)
        }
        composable<ScreenSignIn> {
            ScreenSignIn()
        }
    }
}