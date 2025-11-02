package com.it.shka.feature_main.presentation.screens.profileinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.it.shka.feature_main.R
import com.it.shka.feature_main.presentation.model.CourseUi
import com.it.shka.feature_main.presentation.model.CoursesProfileUi
import com.it.shka.feature_main.presentation.model.SubtopicUi
import com.it.shka.feature_main.presentation.model.TheoryUi
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ScreenCourse(id: Int?, viewModel: MainProfileViewModel){
    val startId = remember { MutableStateFlow<Int?>(id) }
    val mainTopicId = remember { mutableStateOf<Int?>(1) }
    val subtopicId = remember { mutableStateOf(1) }
    LaunchedEffect(startId) {id?.let { viewModel.getCourseById(it, mainTopicId = it, subtopicId = it) } }
    val courseUi by remember { viewModel.courseUiState}.collectAsState()
  when{
      courseUi.isLoading-> Loader()
      courseUi.course != null -> ScreenCourseContent(courseUi.courseProfile!!, courseUi.course!!)
      courseUi.error-> Text(text = "Error", color = Color.White, fontSize = 12.sp)//Добавить диалог
  }



}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ScreenCourseContent(courseUi: CoursesProfileUi, course:List<CourseUi>){
    var startId by remember { mutableStateOf(1) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor = colorResource(R.color.glass),
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(280.dp),
                drawerContainerColor = colorResource(R.color.Dark_gray),
                drawerContentColor = colorResource(R.color.Dark_gray),
                drawerTonalElevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box {
                        GlideImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            model = courseUi.image,
                            contentDescription = "null",
                            contentScale = ContentScale.FillWidth
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .background(color = colorResource(R.color.glass))
                                .align(Alignment.BottomCenter),
                            text = courseUi.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 1.6.em
                        )
                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .windowInsetsPadding(WindowInsets.systemBars)
                            .background(colorResource(R.color.Dark_gray))
                    ) {
                       // itemsIndexed(courseUi.cours){index, item->

                        //}
                        items(course) { course ->
                            MenuListCourse(course, startId, courseUi)

                        }
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
                MainScreenCourse(courseUi =  courseUi.cours.find { it.id == startId }, onNextClick = {startId= startId+1})
            }
        }
    )
}
@Composable
fun MainScreenCourse(courseUi: CourseUi?, onNextClick: () -> Unit){
    val horizontalScroll = rememberScrollState()
    var startId by remember { mutableStateOf(1) }
    var subtopicUi by remember { mutableStateOf<SubtopicUi?>(courseUi?.subtopics?.find { it.id == startId}) }
    LaunchedEffect(courseUi) {
        subtopicUi = courseUi?.subtopics?.find { it.id == startId}
    }
    LaunchedEffect(startId) {
        subtopicUi = courseUi?.subtopics?.find { it.id == startId}
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(horizontalScroll)
    ) {
        Row (
            modifier = Modifier
            .height(50.dp)
            .padding(start = 10.dp, top = 10.dp)
        ){
            Text(
                text = "${courseUi?.main_topic.toString()} /",
                color = colorResource(R.color.Stroke),
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier
                    .padding(start = 5.dp),
                text = "${subtopicUi?.subtopic_id.toString()}.${subtopicUi?.title.toString()}",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = colorResource(R.color.placholder))
        )

        SubtopicUiContent(subtopicUi,  onNextClick = {courseUi?.subtopics?.size.let { if (startId == it)onNextClick() else{ startId = startId+1}}})
    }
}
@Composable
fun SubtopicUiContent(subtopicUi: SubtopicUi?, onNextClick: () -> Unit){
    var startId by remember { mutableStateOf(1) }
    var theoryUi by remember { mutableStateOf<TheoryUi?>(null) }
        LaunchedEffect(subtopicUi) {
            theoryUi = subtopicUi?.theory?.find { it.id == startId}
    }
    LaunchedEffect(startId) {
        theoryUi = subtopicUi?.theory?.find { it.id == startId}
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp)
          ) {


        TheoryUi(theoryUi, onNextClick = { subtopicUi?.theory?.size?.let { if (startId == it) onNextClick()
        else startId = startId+1}})

    }
}
@Composable
fun TheoryUi(theoryUi: TheoryUi?, onNextClick: () -> Unit){
when(theoryUi?.topic){
    "theory"->{TheoryUiContent(theoryUi, onNextClick = {onNextClick() })}
    "tests"->{TestUiContent(theoryUi, onNextClick = {onNextClick()})}

}
}
@Composable
fun TheoryUiContent(theoryUi: TheoryUi, onNextClick:()->Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = theoryUi.title,
            color = Color.White,
            fontSize = 22.sp
        )
        theoryUi.description.forEach {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally),
                text = it,
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ){
            Icon(modifier = Modifier
                .size(50.dp)
                .padding(5.dp),
                painter = painterResource(R.drawable.arrow_circle_left),
                tint = colorResource(R.color.placholder),
                contentDescription = "arrow circle left"
            )
            Icon(modifier = Modifier
                .size(50.dp)
                .padding(5.dp)
                .clickable{
                    onNextClick()
                },
                painter = painterResource(R.drawable.arrow_circle_right),
                tint = colorResource(R.color.placholder),
                contentDescription = "arrow circle right"
            )
        }
    }

}
@Composable
fun TestUiContent(theoryUi: TheoryUi, onNextClick:() -> Unit){
    var selectedOption by remember {mutableStateOf<Int?>(null)}
    var showResult by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }
Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp)
) {
Text(
    modifier = Modifier
        .fillMaxWidth(),
    text = theoryUi.title,
    color = Color.White,
    textAlign = TextAlign.Center,
    fontSize = 22.sp
)
    theoryUi.description.forEach {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = it,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 16.sp
        )
    }
    if (showResult){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            text = if (isCorrect) "Правильно!" else "Неверно. Попробуйте ещё.",
            style = if (isCorrect) MaterialTheme.typography.bodyLarge.copy(color = Color.Green)
            else MaterialTheme.typography.bodyLarge.copy(color = Color.Red),
        )
    }

    theoryUi.options.forEachIndexed { index, optionText->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                               .selectable(
                    selected = selectedOption ==index,
                    onClick = {selectedOption = index},
                    role = Role.RadioButton
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedOption==index,
                onClick = null
            )
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 10.dp),
                text = optionText,
                maxLines = 2,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
    Button(
        modifier = Modifier
            .height(50.dp)
            .align(Alignment.End)
            .padding(10.dp),
        onClick = {
            if (selectedOption != null){
                isCorrect = (selectedOption == theoryUi.correct_option)
                showResult = true
            }
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = colorResource(R.color.button),
            containerColor = colorResource(R.color.button)
        )
    ) {
        Text(
            text = stringResource(R.string.button_option),
            color = Color.White,
            fontSize = 12.sp
        )
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ){
        Icon(modifier = Modifier
            .size(50.dp)
            .padding(5.dp),
            painter = painterResource(R.drawable.arrow_circle_left),
            tint = colorResource(R.color.placholder),
            contentDescription = "arrow circle left"
        )
        Icon(modifier = Modifier
            .size(50.dp)
            .padding(5.dp)
            .clickable{
                onNextClick()
            },
            painter = painterResource(R.drawable.arrow_circle_right),
            tint = colorResource(R.color.placholder),
            contentDescription = "arrow circle right"
        )
    }

}
}
@Composable
fun MenuListCourse(courseUi: CourseUi, Id: Int?, coursesProfileUi: CoursesProfileUi){
    var startId by remember { mutableStateOf(1) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.black))
    ){

           Text(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(30.dp)
                   .padding(start = 10.dp),
               text = "${courseUi.id}.${courseUi.main_topic}",
               color = Color.White,
               fontSize = 12.sp
           )
    }
    courseUi.subtopics.forEach {subtopicUi ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .background(if (subtopicUi.status_id) colorResource(R.color.placholder)else colorResource(R.color.Dark_gray)),
            ) {
            Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp),
                        text = "${subtopicUi.subtopic_id}\t${subtopicUi.title}",
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