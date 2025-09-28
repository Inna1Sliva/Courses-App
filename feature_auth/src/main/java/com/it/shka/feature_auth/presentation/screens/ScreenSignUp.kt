package com.it.shka.feature_auth.presentation.screens
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.it.shka.feature_auth.presentation.screens.AuthUserViewModel
import com.it.shka.feature_auth.R
import com.it.shka.feature_auth.presentation.navigation.rout.RouteAuthScreens

@Composable
fun ScreenSignUp( navController: NavHostController){
    val viewModel = hiltViewModel<AuthUserViewModel>()
    val authMessage = viewModel.authMessage.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rapidPassword by remember { mutableStateOf("") }
    var rPasswordVisibility by remember { mutableStateOf(false) }
    var passwordVisibility by remember { mutableStateOf(false) }



    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ){
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(140.dp))
            Text(modifier = Modifier
                .padding(bottom = 20.dp),
                text = "Регистрация",
                fontSize = 28.sp,
                color = Color.White

            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp),
                text = authMessage.value,
                fontSize = 16.sp,
                color = Color.Red
            )
            Text(
                text = "Email",
                fontSize = 16.sp,
                color = Color.White

                )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp),
                value = email,
                onValueChange = {
                    email= it
                },
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.White),
                placeholder = {
                    Text(
                        text = "Введите почту",
                        fontSize = 14.sp,
                        color = colorResource(R.color.placholder)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(R.color.LightGray),
                    unfocusedContainerColor = colorResource(R.color.LightGray),
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent,
                    focusedIndicatorColor = colorResource(R.color.LightGray),
                    unfocusedIndicatorColor = colorResource(R.color.LightGray),
                    focusedPlaceholderColor = Color.Transparent,
                    cursorColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Text(
                text = "Пароль",
                fontSize = 16.sp,
                color = Color.White


            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp),
                value = password,
                onValueChange = {
                    password= it
                },
                trailingIcon = {
                    IconButton(modifier = Modifier
                        .padding(end = 10.dp),
                        onClick = {
                            passwordVisibility = !passwordVisibility
                        }
                    ) {
                        if (passwordVisibility){
                            Icon(
                                painter = painterResource(R.drawable.remove_red_eye),
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.visibility_off),
                                contentDescription = null
                            )
                        }
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.White),
                placeholder = {
                    Text(
                        text = "Введите пароль",
                        fontSize = 14.sp,
                        color = colorResource(R.color.placholder)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(R.color.LightGray),
                    unfocusedContainerColor = colorResource(R.color.LightGray),
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent,
                    focusedIndicatorColor = colorResource(R.color.LightGray),
                    unfocusedIndicatorColor = colorResource(R.color.LightGray),
                    focusedPlaceholderColor = Color.Transparent,
                    cursorColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Text(
                text = "Повторить пароль",
                fontSize = 16.sp,
                color = Color.White


            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp),
                value = rapidPassword,
                onValueChange = {
                   rapidPassword= it
                },
                trailingIcon = {
                    IconButton(
                        modifier = Modifier
                            .padding(end = 10.dp),
                        onClick = {
                            rPasswordVisibility = !rPasswordVisibility
                        }
                    ) {
                        if (rPasswordVisibility) {
                            Icon(
                                painter = painterResource(R.drawable.remove_red_eye),
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.visibility_off),
                                contentDescription = null
                            )
                        }
                    }
                },
                visualTransformation = if (rPasswordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.White),
                placeholder = {
                    Text(
                        text = "Введите пароль ещё раз",
                        fontSize = 14.sp,
                        color = colorResource(R.color.placholder)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(R.color.LightGray),
                    unfocusedContainerColor = colorResource(R.color.LightGray),
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent,
                    focusedIndicatorColor = colorResource(R.color.LightGray),
                    unfocusedIndicatorColor = colorResource(R.color.LightGray),
                    focusedPlaceholderColor = Color.Transparent,
                    cursorColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(colorResource(R.color.button), shape = RoundedCornerShape(30.dp)),
                onClick = {
                  viewModel.registerUser(email.toString(), password,rapidPassword)
                },

                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.button),
                    containerColor = colorResource(R.color.button)
                )
            ){
                Text(
                    text = "Регистрация",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    fontStyle = FontStyle.Normal
                )

            }
            Row(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.text_signIn),
                    fontSize = 12.sp,
                    color = Color.White

                )
                Text(modifier = Modifier
                    .clickable(
                        onClick = {
                            navController.navigate(RouteAuthScreens.ScreenSignIn.rout)
                        }
                       )
                    .padding(start = 4.dp),
                    text = stringResource(R.string.signIn),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.button)

                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
                    .height(2.dp)
                    .background(colorResource(R.color.Stroke))
            )
            Row (
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ){
                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(50.dp)
                        .background(
                            colorResource(R.color.button_vk),
                            shape = RoundedCornerShape(30.dp)
                        ),
                    ){
                    Icon( modifier = Modifier
                        .size(width = 30.dp, height = 40.dp)
                        .align(Alignment.Center),
                        tint = Color.White,
                        painter = painterResource(R.drawable.vector_icon_vk),
                        contentDescription = null

                    )
                }
                Spacer(modifier = Modifier
                    .size(width = 20.dp, height = 50.dp)
                )

               Box(modifier = Modifier
                   .width(180.dp)
                   .height(50.dp)
                   .background(
                       brush = Brush.linearGradient(
                           colors = listOf(
                               colorResource(R.color.button_ok_1),
                               colorResource(R.color.button_ok_2)
                           ),
                           start = Offset.Zero,
                           end = Offset.Infinite,
                       ),
                       shape = RoundedCornerShape(30.dp)
                   )

                   ) {

                   Icon( modifier = Modifier
                       .size(width = 50.dp, height = 40.dp)
                       .align(Alignment.Center),
                       painter = painterResource(R.drawable.vector_icon_ok),
                       tint = Color.White,
                       contentDescription = null

                   )
               }


            }


        }
    }







}