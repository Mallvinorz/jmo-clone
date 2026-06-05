package com.example.jmoclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.ui.MainScreen
import com.example.jmoclone.ui.auth.AuthViewModel
import com.example.jmoclone.ui.auth.LoginScreen
import com.example.jmoclone.ui.auth.RegisterScreen

@Composable
fun AppNavHost(viewModel: AuthViewModel) {
    val currentUser by viewModel.authState.collectAsState()
//    val isLoggedIn = viewModel.currentUser != null

    if (currentUser != null) {
        MainScreen()
    } else {
        AuthNavGraph(viewModel)
    }
}