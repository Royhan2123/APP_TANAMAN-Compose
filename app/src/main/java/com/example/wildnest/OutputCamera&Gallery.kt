package com.example.wildnest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wildnest.ui.theme.LightGray
import com.example.wildnest.ui.theme.Red

@Composable
fun OutputCameraGallery(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .width(250.dp)
                    .height(200.dp),
                color = Red
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_photo_24),
                    contentDescription = "img-Output",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun OutputCameraGallery() {
    OutputCameraGallery(navController = rememberNavController())
}