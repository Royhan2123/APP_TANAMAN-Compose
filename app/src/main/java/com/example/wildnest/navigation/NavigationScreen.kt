package com.example.wildnest.navigation

enum class NavigationScreen {
    SplashScreen,
    HalamanBottom,
    HomeScreen,
    SettingScreen;

    fun routes(route:String):NavigationScreen
    = when(route.substringBefore("/")){
        SplashScreen.name -> SplashScreen
        HalamanBottom.name -> HalamanBottom
        HomeScreen.name -> HomeScreen
        SettingScreen.name -> SettingScreen
        else -> throw IllegalArgumentException("Route $route is not a recognized")
    }

}