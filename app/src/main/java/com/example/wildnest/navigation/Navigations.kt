package com.example.wildnest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wildnest.HalamanBottom.HalamanBottom
import com.example.wildnest.screen.HomeScreen
import com.example.wildnest.screen.SettingScreen
import com.example.wildnest.screen.SplashScreen

@Composable
fun Navigations(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.SplashScreen.name){
        composable(NavigationScreen.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.HalamanBottom.name){
            HalamanBottom()
        }
        composable(NavigationScreen.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(NavigationScreen.SettingScreen.name){
            SettingScreen(navController = navController)
        }
    }
}