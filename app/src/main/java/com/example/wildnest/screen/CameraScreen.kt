package com.example.wildnest.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wildnest.R
import com.example.wildnest.ui.theme.Black
import com.example.wildnest.ui.theme.LightGray
import com.example.wildnest.ui.theme.White

@Composable
fun CameraScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_cameraswitch_24),
                    contentDescription = "switch-camera",
                    tint = LightGray,
                    modifier = Modifier.size(40.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .size(75.dp)
                        .clip(
                            shape = CircleShape
                        ),
                    colors = ButtonDefaults.buttonColors(
                        White
                    )
                ) {}
            }
        }
    }
}

@Preview
@Composable
fun CameraPreview() {
    CameraScreen(navController = rememberNavController())
}