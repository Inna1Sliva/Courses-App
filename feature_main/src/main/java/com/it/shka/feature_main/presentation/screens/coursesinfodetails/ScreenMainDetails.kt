package com.it.shka.feature_main.presentation.screens.coursesinfodetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.it.shka.feature_main.R
import com.it.shka.feature_main.domain.model.Courses

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ScreenMainDetails(coursesId: String, mainNavigation: NavHostController) {
   val vm = hiltViewModel<MainDetailsViewModel>()
    val coursesUiState by vm.detailsUIState.collectAsState()

   when(coursesUiState){
       is DetailsUiState.Loading -> LoadingContent()
       is DetailsUiState.Success -> ScreenMainDetailsContent((coursesUiState as DetailsUiState.Success).courses, mainNavigation, vm)
       is DetailsUiState.Error ->  ErrorContent()
   }
    LaunchedEffect(coursesId) {
        vm.LoadByIdCourses(coursesId)
    }

}
@Composable
fun ScreenMainDetailsContent(courses: Courses, mainNavigation: NavHostController, vm: MainDetailsViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AppBar(courses, mainNavigation, vm )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = courses.title,
                fontSize = 22.sp,
                color = Color.White
            )
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.button),
                    containerColor = colorResource(R.color.button)
                )
            ) {
                Text(
                    text = stringResource(R.string.start_courses),
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier
                .height(10.dp))
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(start = 10.dp,  end = 10.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.Dark_gray),
                    containerColor = colorResource(R.color.Dark_gray)
                )
            ) {
                Text(
                    text = stringResource(R.string.go_to_the_platform),
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = stringResource(R.string.description_courses),
                fontSize = 22.sp,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = courses.destination,
                color = Color.White,
                fontSize = 14.sp
                //  lineHeight = 1.6.em
            )
        }
    }
}
@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AppBar(courses: Courses, navHostController: NavHostController, vm: MainDetailsViewModel) {
    var hasLike by remember { mutableStateOf(courses.hasLike) }

    Box(
    modifier = Modifier
        .fillMaxWidth()
) {
    GlideImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
              model = courses.image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
    )
    Row (
        modifier= Modifier
            .fillMaxWidth()
            .height(240.dp),
        verticalAlignment = Alignment.Bottom
         ){
        Row(
            modifier= Modifier
                .padding(start = 10.dp, bottom = 10.dp)
                .wrapContentSize()
                .background(color = colorResource(R.color.glass), shape = RoundedCornerShape(10.dp))
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 3.dp, top = 3.dp, end = 2.dp, bottom = 3.dp)
                    .size(width = 12.dp, height = 12.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(R.drawable.star_fill),
                contentDescription = null,
                tint = colorResource(R.color.button)
            )
            Text(
                modifier = Modifier
                    .padding(start = 2.dp, top = 3.dp, end = 3.dp, bottom = 3.dp),
                text = courses.rate,
                fontSize = 12.sp,
                color = Color.White
            )
        }
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )
        Row(
            modifier= Modifier
                .padding(bottom = 10.dp)
                .wrapContentSize()
                .background(color = colorResource(R.color.glass), shape = RoundedCornerShape(10.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(4.dp),
                text = courses.startDate,
                fontSize = 12.sp,
                color = Color.White
            )

        }
    }
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp),
        colors = TopAppBarDefaults.topAppBarColors(
                       containerColor = Color.Transparent,
                     scrolledContainerColor = Color.Transparent
               ),
        title = {

        },
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(width = 44.dp, height = 44.dp)
                    .background(color = Color.White,shape = CircleShape),
                onClick = {
                    navHostController.popBackStack()
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.arraw_left),
                    tint = Color.Black,
                    contentDescription = "arrow left",
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(width = 44.dp, height = 44.dp)
                    .background(color = Color.White, shape = CircleShape),
                onClick = {

                }
            ) {
                when(hasLike){
                    true->{
                        Icon(
                            modifier = Modifier
                                .clickable{
                                    hasLike= false
                                    vm.deleteDbId(id= courses.id)
                                }
                                .size(width = 24.dp, height = 24.dp),
                            painter = painterResource(R.drawable.baseline_bookmark),
                            contentDescription = null,
                            tint = colorResource(R.color.button)
                        )
                    }
                    else -> {
                        Icon(
                            modifier = Modifier
                                .size(width = 24.dp, height = 24.dp)
                                .clickable{
                                    hasLike= true
                                    vm.insertDb(courses)
                                },
                            painter = painterResource(R.drawable.bookmark),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }

            }
        }
    )

}

}
@Composable
fun LoadingContent(){
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
@Composable
fun ErrorContent(){}