package com.example.wildnest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.wildnest.navigation.Navigations
import com.example.wildnest.ui.theme.WildNestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainContent()
        }
    }
    companion object {

    }
}

@Composable
fun MainContent() {
    WildNestTheme {
        Navigations()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   MainContent()
}