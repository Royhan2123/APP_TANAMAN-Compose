package com.example.wildnest.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wildnest.ui.theme.LightGray
import com.example.wildnest.ui.theme.Teal

@Composable
fun HomeScreen(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .offset(y = 70.dp)
        ) {
            Text(
                text = "Welcome To Wild Nest",
                fontSize = 15.sp,
                color = Color(0xFF2CCF99),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "In this application,now you can explore natural\ndiversity interactively.Take a photo of your\nsurroundings, insert an image, and let the app\nreveal the mysteries of nature. Whether it is an\nanimal or a plant, the answer is within your grasp.\nSimple, fun and full of new knowledge every day.\nLet's discover beauty in every corner of nature!",
                fontSize = 13.sp, color = LightGray,
                textAlign = TextAlign.Justify
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .offset(y = 100.dp),
                color = Teal,
                shape = RoundedCornerShape(
                    corner = CornerSize(20.dp)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.CameraAlt,
                        contentDescription = "icon-camera",
                        tint = LightGray,
                        modifier = Modifier.size(35.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun Homeeee() {
    HomeScreen(navController = rememberNavController())
}