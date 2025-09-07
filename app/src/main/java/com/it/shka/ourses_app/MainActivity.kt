package com.it.shka.ourses_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.it.shka.core.presentation.screens.coursesinfo.MainCoursesViewModel
import com.it.shka.core.presentation.navigation.RootNavGraphMainContent
import com.it.shka.feature_onboarding.presentation.navigation.NavigationScreenOnboarding
import com.it.shka.ourses_app.ui.theme.Сourses_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   // private val viewModel: AuthUserViewModel by viewModels<AuthUserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Сourses_AppTheme {

               // ScreenOnboarding()
             //   ScreenMain(mainCoursesViewModel)
                NavigationScreenOnboarding()

            }
        }
    }
}


