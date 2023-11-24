package com.example.wildnest.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Photo
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.wildnest.R
import com.example.wildnest.ui.theme.Black
import com.example.wildnest.ui.theme.Gray
import com.example.wildnest.ui.theme.LightGray
import com.example.wildnest.ui.theme.TealLight
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )
    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }
    val cameraLaucher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) {
        capturedImageUri = uri
    }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(
                context, "Permission Granted", Toast.LENGTH_SHORT
            ).show()
            cameraLaucher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()

        }
    }
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
                fontSize = 20.sp,
                color = Color(0xFF2CCF99),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "In this application, you can now\nExplore natural diversity interactively.\nTake a photo of your surroundings,\nInsert an image, and let the appreveal\nThe mysteries of nature.",
                fontSize = 16.sp, color = LightGray,
                textAlign = TextAlign.Justify
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .width(300.dp)
                        .height(110.dp)
                        .offset(y = 100.dp)
                        .clickable {
                        },
                    color = TealLight,
                    shape = RoundedCornerShape(
                        corner = CornerSize(20.dp)
                    ),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 20.dp, horizontal = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                            contentDescription = "icon-camera",
                            tint = LightGray,
                            modifier = Modifier.size(35.dp)
                        )
                        Spacer(modifier = Modifier.padding(start = 25.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Camera",
                                color = Black,
                                fontWeight = FontWeight.W500
                            )
                            Text(
                                text = "take a picture of \nsomething and see the \nresults of your picture",
                                color = Gray
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .width(300.dp)
                        .height(110.dp)
                        .offset(y = 100.dp)
                        .clickable {
                            val permissionCheckResult = ContextCompat.checkSelfPermission(
                                context, Manifest.permission.CAMERA
                            )
                            if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                                cameraLaucher.launch(uri)
                            } else {
                                permissionLauncher.launch(Manifest.permission.CAMERA)
                            }
                        },
                    color = TealLight,
                    shape = RoundedCornerShape(
                        corner = CornerSize(20.dp)
                    ),
                ) {
                    if (capturedImageUri.path?.isNotEmpty() == true){
                        Image(
                            modifier = Modifier
                                .padding(
                                    16.dp,
                                    8.dp),
                            painter = rememberImagePainter(capturedImageUri),
                            contentDescription = null)
                    }else {
                        Image(
                            modifier = Modifier
                                .padding(
                                    16.dp,
                                    8.dp),
                            imageVector = Icons.Rounded.Photo,
                            contentDescription = null)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 20.dp, horizontal = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_photo_24),
                            contentDescription = "img-picture",
                            tint = LightGray,
                            modifier = Modifier.size(35.dp)
                        )
                        Spacer(modifier = Modifier.padding(start = 25.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Gallery", color = Black,
                                fontWeight = FontWeight.W500
                            )
                            Text(
                                text = "Insert your image\nAnd see the results!",
                                color = Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFilesName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFilesName,
        ".jpg",
        externalCacheDir
    )
    return image
}

@Preview
@Composable
fun Homeeee() {
    HomeScreen(navController = rememberNavController())
}