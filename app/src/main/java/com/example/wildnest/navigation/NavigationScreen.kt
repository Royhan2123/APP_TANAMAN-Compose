package com.example.wildnest.navigation

enum class NavigationScreen {
    SplashScreen,
    HalamanBottom,
    HomeScreen,
    SettingScreen,
    CameraScreen;

    fun routes(route:String):NavigationScreen
    = when(route.substringBefore("/")){
        SplashScreen.name -> SplashScreen
        HalamanBottom.name -> HalamanBottom
        HomeScreen.name -> HomeScreen
        SettingScreen.name -> SettingScreen
        CameraScreen.name -> CameraScreen
        else -> throw IllegalArgumentException("Route $route is not a recognized")
    }

}