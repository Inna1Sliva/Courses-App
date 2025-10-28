package com.it.shka.feature_main.presentation.screens.profileinfo

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.it.shka.feature_main.R
import com.it.shka.feature_main.presentation.model.CourseUi
import com.it.shka.feature_main.presentation.model.CoursesProfileUi

@Composable
fun ScreenCourse(viewModel: MainProfileViewModel){
    val courseUi by remember { viewModel.viewModelState}.collectAsState()
  when{
      courseUi.isLoading-> Loader()
      courseUi.course != null -> ScreenCourseContent(courseUi.course!!)
      courseUi.error-> Text(text = "Error", color = Color.White, fontSize = 12.sp)
  }



}
@Composable
fun ScreenCourseContent(courseUi: List<CoursesProfileUi>){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.black))){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top=10.dp)
        ) {
courseUi.forEach {coursesProfileUi ->
    items(coursesProfileUi.cours) { course ->
        MenuListCourse(course)

    }
}



        }
    }
}
@Composable
fun MenuListCourse(courseUi: CourseUi){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.LightGray))
    ){
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .height(30.dp)
               .background(color = colorResource(R.color.black))
       ) {
           Text(
               text = courseUi.id.toString(),
               color = Color.White,
               fontSize = 12.sp
           )
           Text(
               text = courseUi.main_topic,
               color = Color.White,
               fontSize = 12.sp
           )

       }
    }
}
@Composable
fun Loader(){
    Box (
        modifier = Modifier
            .fillMaxSize()
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .align(Alignment.Center),
            color = colorResource(R.color.button),
            trackColor = colorResource(R.color.LightGray)
        )
    }
}