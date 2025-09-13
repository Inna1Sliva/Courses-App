package com.it.shka.ourses_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.it.shka.feature_onboarding.R
import com.it.shka.ourses_app.ui.theme.Сourses_AppTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
     lifecycleScope.launchWhenCreated {
         delay(2000)
         val intent = Intent(this@SplashActivity, MainActivity::class.java)
         startActivity(intent)
         finish()
     }
        setContent {
            Сourses_AppTheme {
               SplashContentActivity()
            }
        }
    }
}
@Composable
private fun SplashContentActivity() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ){
        Icon(
            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.rubik_cube),
            contentDescription = null,
            tint = colorResource(R.color.button)
        )

    }
}

