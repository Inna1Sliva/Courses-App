package com.it.shka.feature_bottom_nav.presentation.ui

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController

import androidx.navigation.compose.currentBackStackEntryAsState
import com.it.shka.feature_bottom_nav.presentation.model.BottomNavItem
import com.it.shka.feature_bottom_nav.presentation.model.BottomNavViewModel
import com.it.shka.feature_bottom_nav.R
import com.it.shka.feature_bottom_nav.presentation.model.BottomItemUiState


@Composable
fun BottomNavigation(navHostNavAppController: NavHostController) {
    val vm = hiltViewModel<BottomNavViewModel>()
    val badgeState = vm.badgeFavorites.collectAsState()
    val badgeAccount by remember {vm.badgeAccount }.collectAsState()

    NavigationBar(
        modifier = Modifier
            .background(color = colorResource(R.color.Dark_gray)),
        containerColor = colorResource(R.color.Dark_gray)
    ) {
        val backStackEntry by navHostNavAppController.currentBackStackEntryAsState()
        BottomItemNav().forEach { item ->
            NavigationBarItem(
                icon = {
                    BadgedBox(
                        badge = {
                         when(item.badge){
                             1->{}
                             2->{ if ( badgeState.value > 0){
                                 Badge(containerColor = Color.Red) {
                                     Text(
                                         text = badgeState.value.toString(),
                                         color = Color.White
                                     )
                                 }
                             }else{}}
                             3->{
                                 if (badgeAccount > 0){
                                     Badge (containerColor = Color.Red){
                                         Text(
                                             text = badgeAccount.toString(),
                                             color = Color.White
                                         )
                                     }
                                 }
                             }
                         }

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(width = 32.dp, height = 32.dp),
                            painter = painterResource(item.icon),
                            contentDescription = item.title
                        )
                    }

                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.icon_bottom_nav),
                    selectedTextColor = colorResource(R.color.icon_bottom_nav),
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = colorResource(R.color.LightGray)

                ),
                selected = backStackEntry?.destination?.hasRoute(item.route::class) ==true,
                onClick = {
                    navHostNavAppController.navigate(item.route)


                }

            )
        }

    }

}
fun BottomItemNav()= listOf(
    BottomItemUiState.Screen1,
    BottomItemUiState.Screen2,
    BottomItemUiState.Screen3
)