package com.it.shka.ourses_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.it.shka.ourses_app.navigation.AppNavigation
import com.it.shka.ourses_app.ui.theme.Сourses_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Сourses_AppTheme {
                AppNavigation()
            }
        }
    }
}


