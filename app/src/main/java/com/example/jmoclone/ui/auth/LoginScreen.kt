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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.R
import com.example.jmoclone.data.Resource
import com.example.jmoclone.navigation.ScreenNavigation
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun LoginScreen(viewModel: AuthViewModel?, navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authResource = viewModel?.loginFlow?.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeContent.asPaddingValues())
            .padding(horizontal = 16.dp),
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
            Text("Login")
            Text("Silakan login untuk masuk aplikasi")
            InputField(label = "Email Anda", value = email, onValueChange = { email = it })
            InputField(
                label = "Kata Sandi",
                value = password,
                onValueChange = { password = it },
                isPassword = true
            )
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                TextButton(onClick = {}) {
                    Text("Lupa Akun?")
                }
                TextButton(onClick = {}) {
                    Text("Lupa Kata Sandi?")
                }
            }
        }
        Button(onClick = {
            viewModel?.login(email, password)
        }, Modifier.fillMaxWidth(), shape = RoundedCornerShape(4.dp)) {
            Text("Login")
        }
        TextButton(onClick = {}) {
            Text("Buat Akun", color = MaterialTheme.colorScheme.primary)
        }

        authResource?.value?.let {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    CircularProgressIndicator()
                }
                is Resource.Success -> {
                    LaunchedEffect(Unit) {
                        navController.navigate(ScreenNavigation.Home.route){
                            popUpTo(ScreenNavigation.Home.route) { inclusive = true }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun InputField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false
) {
    var isVisible by remember { mutableStateOf(false) }

    val visualTransformation = if (isPassword && !isVisible)
        PasswordVisualTransformation()
    else VisualTransformation.None

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(label)
        },
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { isVisible = !isVisible }) {
                    Icon(
                        painter = painterResource(
                            if (isVisible) R.drawable.material_visibility
                            else R.drawable.material_visibility_off
                        ),
                        contentDescription = if (isVisible) "Show password" else "Hide password"
                    )
                }
            }

        },
        shape = RoundedCornerShape(4.dp),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = when {
                isPassword -> KeyboardType.Password
                else -> KeyboardType.Email
            }
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.primary,
        )
    )
}

@Preview
@Composable
private fun LoginScreenPreview() {
    JMOCloneTheme() {
        LoginScreen(null, rememberNavController())
    }
}