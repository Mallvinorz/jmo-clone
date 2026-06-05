package com.example.jmoclone.ui.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.R
import com.example.jmoclone.data.Resource
import com.example.jmoclone.navigation.ScreenNavigation
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun RegisterScreen(viewModel: AuthViewModel?, navController: NavController) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authResource = viewModel?.signupFlow?.collectAsState()

    Surface() {

        if (authResource is Resource.Loading) {
            CircularProgressIndicator()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(WindowInsets.safeContent.asPaddingValues()),
//                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(48.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.mock_square_logo),
                    contentDescription = "JMO Mock Logo",
                    modifier = Modifier.size(48.dp)
                )
                Image(painter = painterResource(R.drawable.jmo_logo), contentDescription = "JMO")
            }
            Spacer(Modifier.size(48.dp))
            Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Signup", fontWeight = FontWeight.Bold)
                Text("Silakan registrasi untuk masuk aplikasi", style = MaterialTheme.typography.bodySmall)
                InputField(label = "Nama Anda", value = name, onValueChange = { name = it})
                InputField(label = "Email Anda", value = email, onValueChange = { email = it })
                InputField(
                    label = "Kata Sandi",
                    value = password,
                    onValueChange = { password = it },
                    isPassword = true
                )
            }
            Spacer(Modifier.size(20.dp))
            Button(onClick = {
                viewModel?.signup(name, email, password)
            }, Modifier.fillMaxWidth(), shape = RoundedCornerShape(4.dp)) {
                Text("Signup")
            }

            TextButton(onClick = {
                navController.navigate(ScreenNavigation.Login.route){
                    popUpTo ( ScreenNavigation.Login.route ) { inclusive = true }
                }
            }) {
                Text("Login", color = MaterialTheme.colorScheme.primary)
            }

            authResource?.value?.let {
                when (it) {
                    is Resource.Failure -> {
                        Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Success -> {
                        LaunchedEffect(Unit) {
                            navController.navigate(ScreenNavigation.Main.route) {
                                popUpTo(ScreenNavigation.Main.route) { inclusive = true }
                            }
                        }
                    }
                    is Resource.Loading -> {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    JMOCloneTheme() {
        RegisterScreen(null, rememberNavController())
    }
}