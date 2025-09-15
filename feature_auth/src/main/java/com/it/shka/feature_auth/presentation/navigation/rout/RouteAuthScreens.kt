package com.it.shka.feature_auth.presentation.navigation.rout

sealed class RouteAuthScreens(val rout:String){
    object ScreenSignIn: RouteAuthScreens("SignIn")
    object ScreenSignUp: RouteAuthScreens("SignUp")
}
