package com.it.shka.feature_main.presentation.navigation

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
import com.it.shka.feature_main.presentation.screens.favoritesinfo.ScreenFavorites
import com.it.shka.feature_main.presentation.screens.profileinfo.ScreenProfile
import com.it.shka.feature_main.presentation.route.RouteBottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootNavGraphMainContent(){
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
                startDestination = RouteBottomNavigation.ScreenMain.route,
                Modifier.padding(innerPadding)
            ){
                composable(RouteBottomNavigation.ScreenMain.route) {
                    ScreenMainNavigation(scrollBehavior)

                }
                composable(RouteBottomNavigation.ScreenFavorits.route){
                    ScreenFavorites()
                }
                composable(RouteBottomNavigation.ScreenProfile.route ) {
                    ScreenProfileNavigation()
                }
            }
        },
        contentColor = Color.Black,
        containerColor = Color.Black
    )
}
