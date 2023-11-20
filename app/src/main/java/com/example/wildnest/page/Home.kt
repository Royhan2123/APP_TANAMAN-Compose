package com.example.wildnest.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home(){
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "INI HALAMAN HOME")
    }
}

@Preview
@Composable
fun Homeeee(){
   Home()
}