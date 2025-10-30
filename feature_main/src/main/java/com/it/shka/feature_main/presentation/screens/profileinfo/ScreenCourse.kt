package com.it.shka.feature_main.presentation.screens.profileinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.it.shka.feature_main.presentation.model.SubtopicUi
import com.it.shka.feature_main.presentation.model.TheoryUi
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ScreenCourse(id: Int?, viewModel: MainProfileViewModel){
    val startId = remember { MutableStateFlow<Int?>(id) }
    LaunchedEffect(startId) {id?.let { viewModel.getCourseById(it) } }
    val courseUi by remember { viewModel.courseUiState}.collectAsState()
  when{
      courseUi.isLoading-> Loader()
      courseUi.course != null -> ScreenCourseContent(courseUi.course!!)
      courseUi.error-> Text(text = "Error", color = Color.White, fontSize = 12.sp)//Добавить диалог
  }



}
@Composable
fun ScreenCourseContent(courseUi: CoursesProfileUi){
    val startId by remember { mutableStateOf(1) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor = colorResource(R.color.glass),
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = colorResource(R.color.Dark_gray),
                drawerContentColor = colorResource(R.color.Dark_gray),
                drawerTonalElevation = 6.dp
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.systemBars)
                        .background(colorResource(R.color.Dark_gray))
                ) {
                    items(courseUi.cours) { course ->
                        MenuListCourse(course)

                    }
                }
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 45.dp)
                    .background(color = colorResource(R.color.black))
            ){
                MainScreenCourse(courseUi =  courseUi.cours.find { it.id == startId })
            }
        }
    )
}
@Composable
fun MainScreenCourse(courseUi: CourseUi?){
    val startId by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Text(
            modifier = Modifier
                .height(50.dp)
                .padding(start = 10.dp),
                text = courseUi?.main_topic.toString(),
                color = Color.White,
                fontSize = 22.sp
            )
        SubtopicUiContent(courseUi?.subtopics?.find { it.id == startId}, startId)
    }
}
@Composable
fun SubtopicUiContent(subtopicUi: SubtopicUi?, id: Int){
    val startId by remember { mutableStateOf(id) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = colorResource(R.color.placholder))
        )
        Text(
            modifier = Modifier
                .height(50.dp)
                .padding( 10.dp),
                text = subtopicUi?.subtopic_id.toString(),
                color = Color.White,
                fontSize = 16.sp
            )
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = colorResource(R.color.placholder))
             )

    }
}
@Composable
fun TheoryUiContent(theoryUi: TheoryUi?){

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
               modifier = Modifier
                   .padding(end = 5.dp),
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
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .background(color = colorResource(R.color.LightGray))
                  ) {
            courseUi.subtopics.forEach {subtopicUi ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        modifier = Modifier
                        .padding(end = 5.dp),
                        text = subtopicUi.subtopic_id,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Text(
                        text = subtopicUi.title,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }

            }

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