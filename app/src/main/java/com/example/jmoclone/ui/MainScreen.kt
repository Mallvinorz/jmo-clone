package com.example.jmoclone.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.navigation.ScreenNavigation
import com.example.jmoclone.ui.auth.LoginScreen
import com.example.jmoclone.ui.components.BottomBar
import com.example.jmoclone.ui.home.HomeScreen
import com.example.jmoclone.ui.news.NewsScreen
import com.example.jmoclone.ui.profile.ProfileScreen
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun MainScreen(
    startDestination: String = ScreenNavigation.Home.route
) {
    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomBar(navController) }) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(ScreenNavigation.Home.route) {
                HomeScreen()
            }
            composable(ScreenNavigation.News.route) {
                NewsScreen()
            }
            composable(ScreenNavigation.Profile.route) {
                ProfileScreen(null, navController)
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    JMOCloneTheme() {
        MainScreen()
    }
}