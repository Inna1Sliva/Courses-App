package com.it.shka.feature_onboarding.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.it.shka.feature_onboarding.R
import com.it.shka.feature_onboarding.presentation.route.RouteOnboarding
import java.util.UUID

@Composable
fun ScreenMain(navHostController: NavHostController, mainContent:()-> Unit, navOnboardingController: NavHostController){
    //val userId = UUID.randomUUID().toString()
    val vm = hiltViewModel<MainViewModel>()
    val userIdState = vm.userIdState.collectAsState()

        when(userIdState.value.authId?.isNotEmpty()){
            true->{
                mainContent
            }
            else -> {
             //   navHostController.navigate(RouteOnboarding.ScreenMain.rout)
            }
        }


    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,


        ){
        Text(
            modifier = Modifier
                .padding(top = 130.dp)
                .size(width = 285.dp, height = 72.dp),
            text = "Тысячи курсов \nв одном месте",
            fontSize = 28.sp,
            color = Color.White,
            textAlign = TextAlign.Center

        )
        Image(
            modifier = Modifier
                .height(316.dp)
                .width(1000.dp)
                .padding(top = 15.dp),
            painter = painterResource(R.drawable.courses),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(color = colorResource(R.color.button), shape = RoundedCornerShape(100.dp)),
            onClick = {
                navHostController.navigate(RouteOnboarding.ScreenAuthUser.rout){
                 launchSingleTop = true
                   popUpTo(navHostController.graph.startDestinationId){
                       inclusive = true
                   }
               }
                      },
            colors =ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.button),
                contentColor =  colorResource(R.color.button)
            )) {
            Text(text = "Продолжить",
                color = Color.White,
                fontSize = 14.sp)

        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))

    }}