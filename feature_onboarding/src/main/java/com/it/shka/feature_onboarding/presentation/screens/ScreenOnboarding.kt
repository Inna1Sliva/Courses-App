package com.it.shka.feature_onboarding.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.it.shka.feature_onboarding.R
import com.it.shka.feature_onboarding.presentation.route.RouteOnboarding
import kotlinx.coroutines.delay


@Composable
fun ScreenOnboarding(main:()-> Unit, navHostController: NavHostController){
    val vm = hiltViewModel<MainViewModel>()
    val userIdState = vm.userIdState.collectAsState()
    LaunchedEffect(Unit) {
        when(userIdState.value.authId?.isNotEmpty()){
            true->{
              main
            }

            else -> {
                navHostController.navigate(RouteOnboarding.ScreenMain.rout)
            }
        }


    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ){
        Icon(
            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.rubik_cube),
            contentDescription = null,
            tint = colorResource(R.color.button)
        )

    }

}