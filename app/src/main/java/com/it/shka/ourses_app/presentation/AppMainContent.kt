package com.it.shka.ourses_app.presentation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.core.navigation.AccountScreen
import com.it.shka.core.navigation.FavoritesScreen
import com.it.shka.core.navigation.MainScreen
import com.it.shka.feature_bottom_nav.presentation.ui.BottomNavigation
import com.it.shka.feature_main.presentation.navigation.ScreenMainNavigation
import com.it.shka.feature_main.presentation.navigation.ScreenProfileNavigation
import com.it.shka.feature_favorites.presentation.ScreenFavorites

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppMainContent(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(snapAnimationSpec = spring(stiffness = Spring.DampingRatioHighBouncy))
    val navBottomNavigation = rememberNavController()
    Scaffold (
        modifier = Modifier
            .consumeWindowInsets(WindowInsets.statusBars)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            BottomNavigation(navBottomNavigation)
        },
        content = { innerPadding ->
            NavHost(
                navController = navBottomNavigation,
                startDestination = MainScreen,
                Modifier.padding(innerPadding)
            ){
                composable<MainScreen> {
                    ScreenMainNavigation(scrollBehavior)

                }
                composable<FavoritesScreen>{
                    ScreenFavorites()
                }
                composable<AccountScreen> {
                    ScreenProfileNavigation()
                }
            }
        },
        contentColor = Color.Black,
        containerColor = Color.Black
    )
}