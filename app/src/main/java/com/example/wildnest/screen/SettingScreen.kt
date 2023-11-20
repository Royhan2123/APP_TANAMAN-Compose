package com.example.wildnest.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingScreen(navController: NavController){
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Preview
@Composable
fun Settingss(){
    SettingScreen(navController = rememberNavController())
}