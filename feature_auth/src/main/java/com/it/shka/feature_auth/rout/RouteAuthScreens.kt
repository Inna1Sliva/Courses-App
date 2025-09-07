package com.it.shka.feature_auth.rout

sealed class RouteAuthScreens(val rout:String){
    object ScreenSignIn: RouteAuthScreens("SignIn")
    object ScreenSignUp: RouteAuthScreens("SignUp")
}
