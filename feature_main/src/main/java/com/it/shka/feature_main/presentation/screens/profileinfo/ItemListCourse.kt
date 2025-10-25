package com.it.shka.feature_main.presentation.screens.profileinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.it.shka.feature_main.R
import com.it.shka.feature_main.presentation.model.CoursesProfileUi

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemListCourse(modifier: Modifier, course: CoursesProfileUi,){
   // var hasLike by remember { mutableStateOf(courses.hasLike) }

    Column(
        modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(colorResource(R.color.LightGray), shape = RoundedCornerShape(16.dp))
    )    {
        Box(
            modifier
                .fillMaxWidth()
                .background(color = Color.Blue, shape = RoundedCornerShape(16.dp))
                .height(114.dp)
        ){
            GlideImage(
                modifier = Modifier
                 .height(114.dp)
                 .clip(RoundedCornerShape(16.dp)),
               // .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
                model = course.image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )

            Row (
                modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

            Row (
                modifier
                    .padding(5.dp)
                    .height(114.dp),
              verticalAlignment = Alignment.Bottom
                  //  .background(color = colorResource(R.color.glass), shape = RoundedCornerShape(10.dp))
            ){
                Row(
                    modifier
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
                        text = course.rate,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                )
                Row(
                    modifier
                       //.padding(4.dp)
                        .wrapContentSize()
                        .background(color = colorResource(R.color.glass), shape = RoundedCornerShape(10.dp)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = course.startDate,
                        fontSize = 12.sp,
                        color = Color.White
                    )

                }
            }
                Spacer(
                    modifier
                        .width(30.dp)
                )
               Row (
                   modifier
                       .padding(5.dp)
                       .wrapContentSize()
                       .background(color = colorResource(R.color.glass), shape = CircleShape),
                   horizontalArrangement = Arrangement.End

               ) {

                           Icon(modifier = Modifier
                               .padding(10.dp)
                               .size(width = 24.dp, height = 24.dp),
                               tint = Color.White,
                               painter = painterResource(R.drawable.bookmark),
                               contentDescription = null
                           )
                       }
                }
            }
        }
        Text(modifier = Modifier
            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 5.dp),
            text = course.title,
            fontSize = 16.sp,
            color = Color.White
        )
        Text(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp),
            text = course.text,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 1.6.em,
            fontSize = 10.sp,
            color = Color.White
        )
        Row(
            modifier
                .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = course.price,
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(
                modifier = Modifier
                    .width(30.dp)
            )
            Row {
                Text(
                    modifier= Modifier
                        .clickable{
                           // mainCoursesViewModel.setDetailCourses(courses)
                           // navHostController.navigate(RoutScreenMain.ScreenMainDetail.rout)
                                  },
                    text = "Подробнее",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.button)
                )
                Icon(modifier = Modifier
                    .size(width = 16.dp, height = 16.dp)
                    .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.arrow_right_short_fill),
                    contentDescription = null,
                    tint = colorResource(R.color.button)

                )
            }
        }

    }