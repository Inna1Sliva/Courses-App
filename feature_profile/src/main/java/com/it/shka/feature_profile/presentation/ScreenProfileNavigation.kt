package com.it.shka.feature_profile.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.navigation.AccountScreen
import com.it.shka.core.navigation.AccountScreenCourses
import com.it.shka.feature_profile.presentation.model.MainProfileViewModel
import com.it.shka.feature_profile.ScreenCourse
import com.it.shka.feature_profile.ScreenProfile

@Composable
fun ScreenProfileNavigation(){
val navController = rememberNavController()
    val viewModel = hiltViewModel<MainProfileViewModel>()
    NavHost(
        navController = navController,
        startDestination = AccountScreen
    ){
        composable<AccountScreen>{
            ScreenProfile(viewModel,navController)
        }
        composable("${AccountScreenCourses}/{courseId}"){
            val id = it.arguments?.getString("courseId")
            ScreenCourse(id?.toInt(),viewModel)
        }
    }
}