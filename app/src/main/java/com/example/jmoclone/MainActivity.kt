package com.example.jmoclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.jmoclone.navigation.AppNavHost
import com.example.jmoclone.ui.auth.AuthViewModel
import com.example.jmoclone.ui.theme.JMOCloneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JMOCloneTheme {
                AppNavHost(viewModel)
            }
        }
    }
}