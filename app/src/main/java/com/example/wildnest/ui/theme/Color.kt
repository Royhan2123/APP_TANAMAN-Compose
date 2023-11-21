package com.example.wildnest.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val Red = Color(0xFFFA0000)
val Gray = Color(0xFF8A8A8A)
val Blue = Color(0xFF000CF8)
val Cyan = Color(0xFF00F7F7)
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val LightGray = Color(0xFFADADAD)
val LightRed = Color(0xFFFF6C79)
val Yellow = Color(0xFFFFDB00)
val Teal = Color(0xFF0FE983)
val Primary = Color(0xFF75107C)
val Green = Color(0xFF00FF0C)

sealed class ThemeColor(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val text: Color,
) {
    object Dark : ThemeColor(
        background = Color(0xFF000000),
        surface = Color(0xFF000000),
        primary = Color(0xFF49CE25),
        text = Color(0xFFFFFFFF),
    )
    object Light : ThemeColor(
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFFFFFFF),
        primary = Color(0xFFFFFB7F),
        text = Color(0xFF070707),
    )
}