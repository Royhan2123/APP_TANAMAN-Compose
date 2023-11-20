package com.example.wildnest.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Setting(){
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "INI HALAMAN SETTING")
    }
}

@Preview
@Composable
fun Settingss(){
    Setting()
}