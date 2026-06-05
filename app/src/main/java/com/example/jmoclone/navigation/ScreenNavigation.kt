package com.example.jmoclone.navigation

sealed class ScreenNavigation(val route: String) {
    object Login: ScreenNavigation("login")
    object Register: ScreenNavigation("register")
    object Main: ScreenNavigation("main")
    object Home: ScreenNavigation("home")
    object News: ScreenNavigation("news")
    object Profile: ScreenNavigation("profile")
}