package com.it.shka.feature_main.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.it.shka.feature_main.R
import com.it.shka.feature_main.presentation.model.BottomNavItem
import com.it.shka.feature_main.presentation.route.RouteBottomNavigation
import com.it.shka.feature_main.presentation.screens.coursesinfo.MainCoursesViewModel

@Composable
fun BottomNavigation(NavHostController: NavHostController){
val vm = hiltViewModel<MainCoursesViewModel>()
    val badgeState = vm.badgeFavorites.collectAsState()

    val navItem = listOf<BottomNavItem>(
    BottomNavItem("Главная", R.drawable.home, RouteBottomNavigation.ScreenMain.route, badge = null ),
    BottomNavItem("Избранное", R.drawable.bookmark, RouteBottomNavigation.ScreenFavorits.route, badge = badgeState.value),
    BottomNavItem("Аккаунт", R.drawable.account, RouteBottomNavigation.ScreenProfile.route, badge = null)
)
    NavigationBar(
        modifier = Modifier
            .background(color = colorResource(R.color.Dark_gray)),
        containerColor = colorResource(R.color.Dark_gray)
    ) {
        navItem.forEach { item->
    NavigationBarItem(
        icon = {
            BadgedBox(
                badge={
                    item.badge?.let {
                        if (it > 0){
                            Badge(contentColor = Color.Red){
                                Text(
                                    text = item.badge.toString(),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(width = 32.dp, height = 32.dp),
                    painter = painterResource(item.icon),
                    contentDescription = item.label
                )
            }

        },
        label = {
            Text(
                text = item.label,
                fontSize = 12.sp
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = colorResource(R.color.button),
            selectedTextColor = colorResource(R.color.button),
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.White,
            indicatorColor = colorResource(R.color.LightGray)

        ),
        selected = NavHostController.currentBackStackEntryAsState().value?.destination?.route == item.route,
        onClick = {
            NavHostController.navigate(item.route){
                launchSingleTop = true
                restoreState = true
            }
        }

    )
        }

    }
}