package com.it.shka.feature_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.it.shka.feature_profile.domain.model.UserResponse
import com.it.shka.feature_profile.presentation.CoursesUiState
import com.it.shka.feature_profile.presentation.model.MainProfileViewModel

@Composable
fun ScreenProfile(viewModel: MainProfileViewModel, navControllerProfile: NavController) {
    val uiState by remember { viewModel.coursesUiState }.collectAsState()
   // val token by remember { viewModel.tokenUser }.collectAsState()

    when (uiState){
       is CoursesUiState.Loading -> LoadingProfile()
        is CoursesUiState.Courses  -> ScreenProfileContent(uiState =(uiState as CoursesUiState.Courses).user, navControllerProfile)
        is CoursesUiState.Error -> LoadingProfile()

    }

}

@Composable
fun ScreenProfileContent(uiState: UserResponse, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 10.dp, end = 10.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = stringResource(R.string.profile),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.W400
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        color = colorResource(R.color.Dark_gray),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.chat_notification),
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W500
                    )
                    Box(
                        modifier = Modifier
                            .size(width = 15.dp, height = 15.dp)
                            .align(Alignment.CenterVertically)
                            .background(
                                color = Color.Red,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center),
                            text = uiState.notification.push.count { !it.status }.toString(),
                            fontSize = 12.sp,
                            color = Color.White,

                            )
                    }
                    Spacer(
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Icon(
                        modifier = Modifier
                            .size(width = 24.dp, height = 24.dp),
                        painter = painterResource(R.drawable.arrow_forward),
                        contentDescription = "arrow forward",
                        tint = Color.White
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .height(1.dp)
                        .background(color = colorResource(R.color.Stroke))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.Write_to_support),
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W500
                    )
                    Spacer(
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Icon(
                        modifier = Modifier
                            .size(width = 24.dp, height = 24.dp),
                        painter = painterResource(R.drawable.arrow_forward),
                        contentDescription = "arrow forward",
                        tint = Color.White
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .height(1.dp)
                        .background(color = colorResource(R.color.Stroke))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.Settings),
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W500
                    )
                    Spacer(
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Icon(
                        modifier = Modifier
                            .size(width = 24.dp, height = 24.dp),
                        painter = painterResource(R.drawable.arrow_forward),
                        contentDescription = "arrow forward",
                        tint = Color.White
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .height(1.dp)
                        .background(color = colorResource(R.color.Stroke))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.Log_out_of_your_account),
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W500
                    )
                    Spacer(
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Icon(
                        modifier = Modifier
                            .size(width = 24.dp, height = 24.dp),
                        painter = painterResource(R.drawable.arrow_forward),
                        contentDescription = "arrow forward",
                        tint = Color.White
                    )
                }

            }
            when{
                uiState.courses.isEmpty() -> {
                  Text(
                      modifier = Modifier
                          .padding(start = 10.dp, top = 20.dp, end = 10.dp),
                      text = stringResource(R.string.title_empty),
                      fontSize = 22.sp,
                      color = colorResource(R.color.placholder),
                      fontWeight = FontWeight.W400
                  )
              }
                else -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp, top = 20.dp, end = 10.dp),
                        text = stringResource(R.string.Your_courses),
                        fontSize = 22.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W400
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        items(listOf(uiState.courses)) {
                            it.forEach { coursesProfileUi ->
                                ItemListCourse(navController, course = coursesProfileUi)
                            }

                        }
                    }
                }


            }


        }
    }
}

@Composable
fun LoadingProfile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .align(Alignment.Center),
            color = colorResource(R.color.button),
            trackColor = colorResource(R.color.Stroke)
        )
    }
}
