package com.example.jmoclone.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.R
import com.example.jmoclone.navigation.ScreenNavigation
import com.example.jmoclone.ui.auth.AuthViewModel
import com.example.jmoclone.ui.theme.JMOCloneTheme
import com.google.firebase.auth.UserInfo
import androidx.compose.runtime.collectAsState

@Composable
fun ProfileScreen(viewModel: AuthViewModel? = hiltViewModel(), navController: NavController) {
    val user = viewModel?.authState?.collectAsState()?.value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card() {
            Column() {
                Text(user?.displayName.toString())
            }
        }
        ProfileMenuList()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("1.0.0")
            IconTexButton({
                viewModel?.logout()
//                navController.navigate(ScreenNavigation.Login.route) {
//                    popUpTo(0) { inclusive = true }
//                    launchSingleTop = true
//                }
            })
        }
    }
}

@Composable
fun IconTexButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier.clickable { onClick() }, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Icon(painter = painterResource(R.drawable.material_logout), contentDescription = null)
        Text("Keluar")
    }
}



@Preview
@Composable
private fun ProfileScreenPreview() {
    JMOCloneTheme() {
        ProfileScreen(null, rememberNavController())
    }
}