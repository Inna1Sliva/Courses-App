package com.it.shka.feature_main.presentation.screens.profileinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.it.shka.feature_main.R

@Composable
fun ScreenCourse(){
val viewModel = hiltViewModel<MainProfileViewModel>()
    val courseUi = viewModel.courseUi.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.black))){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top=10.dp)
        ) {
            courseUi.value.forEach {courseUi ->
                stickyHeader {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                    ){
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
                items(courseUi.subtopics){subtopicUi->
                    Row (
                        modifier = Modifier
                            .height(30.dp)
                            .background(colorResource(R.color.Stroke))
                    ){
                        Text(
                            text = subtopicUi.subtopic_id,
                            color = Color.White,
                            fontSize = 10.sp
                        )
                        Text(
                        text = subtopicUi.title,
                        color = Color.White,
                        fontSize = 10.sp
                         )
                    }

                }

           }
        }
    }
}