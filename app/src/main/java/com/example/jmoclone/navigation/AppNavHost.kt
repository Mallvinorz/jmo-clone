package com.example.jmoclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.ui.MainScreen
import com.example.jmoclone.ui.auth.AuthViewModel
import com.example.jmoclone.ui.auth.LoginScreen
import com.example.jmoclone.ui.auth.RegisterScreen

@Composable
fun AppNavHost(viewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.Login.route
    ){
        composable(ScreenNavigation.Login.route){
            LoginScreen(viewModel, navController)
        }
        composable(ScreenNavigation.Register.route) {
            RegisterScreen(viewModel, navController)
        }
        composable(ScreenNavigation.Main.route){
            MainScreen()
        }
    }
}