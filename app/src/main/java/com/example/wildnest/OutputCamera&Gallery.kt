package com.example.wildnest

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wildnest.ui.theme.Gray
import com.example.wildnest.ui.theme.Teal
import com.example.wildnest.ui.theme.White
import org.intellij.lang.annotations.JdkConstants.FontStyle

@Composable
fun OutputCameraGallery(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription = "img-Output",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(300.dp)
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(200.dp)
                    .height(45.dp),
                shape = RoundedCornerShape(
                    corner = CornerSize(20.dp)
                ),
                colors = ButtonDefaults.buttonColors(
                    Teal
                ),
                elevation = ButtonDefaults.elevation(
                    10.dp
                )
            ) {
                Text(text = "Find Out", color = White, fontSize = 15.sp)
            }
            // TODO THIS OUTPUT
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = " // Output",
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    color = Gray)
            }
        }
    }
}

@Preview
@Composable
fun OutputCameraGallery() {
    OutputCameraGallery(navController = rememberNavController())
}