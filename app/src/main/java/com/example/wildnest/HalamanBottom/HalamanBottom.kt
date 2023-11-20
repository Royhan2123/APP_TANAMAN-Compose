package com.example.wildnest.HalamanBottom

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wildnest.screen.HomeScreen
import com.example.wildnest.screen.SettingScreen

sealed class BottomNav(
    val icon: ImageVector,
    val title: String,
    val route: String
) {
    object Home : BottomNav(icon = Icons.Rounded.Home, title = "Home", route = "home")
    object Setting : BottomNav(icon = Icons.Rounded.Settings, title = "Setting", route = "setting")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNav.Home.route) {
        composable(BottomNav.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(BottomNav.Setting.route) {
            SettingScreen(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomNav.Home,
        BottomNav.Setting,
    )
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val navBackStateEntry by navController.currentBackStackEntryAsState()
        val screenRoute = navBackStateEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = item.route == screenRoute,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { routing ->
                            popUpTo(routing) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (item.route == screenRoute)Color.Cyan else Color.Gray
                    )
                },
                label = {
                    Text(text = item.title, color = if (item.route == screenRoute)Color.Cyan else Color.Gray,
                        fontSize = 15.sp)
                },
                alwaysShowLabel = true
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HalamanBottom(){
    val navController = rememberNavController()

    Scaffold (
        bottomBar = { BottomBar(navController = navController)}
    ) {
        NavigationGraph(navController = navController)
    }
}

@Preview
@Composable
fun PreviewHalamanBottom(){
    HalamanBottom()
}