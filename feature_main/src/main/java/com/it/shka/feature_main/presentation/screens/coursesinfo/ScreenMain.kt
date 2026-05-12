package com.it.shka.feature_main.presentation.screens.coursesinfo

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.it.shka.feature_main.R
import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.presentation.screens.coursesinfo.model.MainCoursesViewModel
import com.it.shka.feature_main.presentation.screens.ItemListCourses
import com.it.shka.feature_main.presentation.screens.coursesinfo.model.MainUIState


@Composable
fun ScreenMain(navHostController: NavHostController) {
    val vm = hiltViewModel<MainCoursesViewModel>()
    val coursesUiState by vm.coursesUiState.collectAsState()
    when (coursesUiState) {
        is MainUIState.Loading -> LoadingContent()
        is MainUIState.Success -> ScreenMainContent(navHostController, vm)
        is MainUIState.Error -> ErrorContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMainContent(navHostController: NavHostController, vm: MainCoursesViewModel) {
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(snapAnimationSpec = spring(stiffness = Spring.DampingRatioHighBouncy))
    val courses =vm.pageCourses.collectAsLazyPagingItems()
    val coursesUiState by vm.coursesUiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp)
            .background(Color.Black)
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        mainAppBar(scrollBehavior, vm, searchOnClick = {
            vm.setSearchQuery(it)
        })

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(R.string.text_data_option),
                fontSize = 14.sp,
                color = colorResource(R.color.button)
            )
            Spacer(
                modifier = Modifier
                    .width(5.dp)
            )
            Icon(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(width = 16.dp, height = 16.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(R.drawable.arrow_down_up),
                tint = colorResource(R.color.button),
                contentDescription = "arrow dawn up"
            )

        }
        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()

        ) {
            items(count = courses.itemCount, key = courses.itemKey())
            { index ->
                val listCourses = courses[index] ?: return@items
                ItemListCourses(
                    modifier = Modifier,
                    listCourses,
                    navHostController,
                    vm
                )

            }
            courses.apply {
                when {

                    loadState.append is LoadState.Loading -> {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .size(width = 28.dp, height = 28.dp),
                                    color = Color.Blue
                                )
                            }
                        }
                    }


                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    vm: MainCoursesViewModel,
    searchOnClick: (String) -> Unit
) {
    var searchCourses by remember { mutableStateOf("") }

    TopAppBar(
        modifier = Modifier
            .padding(bottom = 10.dp),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            scrolledContainerColor = Color.Black
        ),
        title = {
            OutlinedTextField(
                modifier = Modifier
                    .width(300.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(onSearch = {
                    searchOnClick(searchCourses)
                }),
                value = searchCourses,
                onValueChange = { search ->
                    searchCourses = search
                },
                textStyle = TextStyle(fontSize = 14.sp, color = Color.White),
                placeholder = {
                    Text(
                        text = "Search courses...",
                        fontSize = 14.sp,
                        color = colorResource(R.color.placholder)
                    )
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(width = 28.dp, height = 28.dp),
                        painter = painterResource(R.drawable.search),
                        contentDescription = "search icon",
                        tint = Color.White
                    )
                },
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(R.color.LightGray),
                    unfocusedContainerColor = colorResource(R.color.LightGray),
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent,
                    focusedIndicatorColor = colorResource(R.color.LightGray),
                    unfocusedIndicatorColor = colorResource(R.color.LightGray),
                    focusedPlaceholderColor = Color.Transparent,
                    cursorColor = Color.White
                )

            )
        },
        actions = {
            IconButton(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(width = 56.dp, height = 56.dp)
                    .background(color = colorResource(R.color.LightGray), shape = CircleShape),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp),
                    painter = painterResource(R.drawable.funnel),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun LoadingContent() {
    Box(modifier = Modifier
        .fillMaxSize()
              .background(color = colorResource(R.color.dark_gray_blur))) {
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
fun ErrorContent() {

}