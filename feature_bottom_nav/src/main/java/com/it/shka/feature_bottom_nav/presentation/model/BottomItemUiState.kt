package com.it.shka.feature_bottom_nav.presentation.model

import com.it.shka.core.navigation.AccountScreen
import com.it.shka.core.navigation.AppRoute
import com.it.shka.core.navigation.FavoritesScreen
import com.it.shka.core.navigation.MainScreen
import com.it.shka.feature_bottom_nav.R

sealed class BottomItemUiState(val title: String, val icon: Int, val route: AppRoute, val badge: Int) {
    object Screen1 : BottomItemUiState( "Главная", R.drawable.home, MainScreen, badge = 1)
    object Screen2 : BottomItemUiState( "Избранное", R.drawable.bookmark, FavoritesScreen, badge=2)
    object Screen3 : BottomItemUiState( "Аккаунт", R.drawable.account, AccountScreen, badge =3)

}