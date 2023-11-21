package com.example.wildnest.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wildnest.R
import com.example.wildnest.navigation.NavigationScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.graph.startDestinationRoute?.let {
            navController.popBackStack(
                route = it,
                inclusive = true
            )
        }
        navController.navigate(NavigationScreen.HalamanBottom.name)
    }
   Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .size(300.dp)
                    .scale(scale.value),
                ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_splash),
                        contentDescription = "Splash Screen",
                        modifier = Modifier.size(120.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewsSplash(){
    SplashScreen(navController = rememberNavController())
}
