package com.example.jmoclone.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.navigation.ScreenNavigation
import com.example.jmoclone.ui.components.BottomBar
import com.example.jmoclone.ui.home.HomeScreen
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ScreenNavigation.Home.route
) {
    Scaffold(bottomBar = { BottomBar(navController) }) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(ScreenNavigation.Home.route) {
                HomeScreen()
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