package com.example.jmoclone.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jmoclone.R
import com.example.jmoclone.data.BottomBarItem
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun BottomBar(navController: NavController, modifier: Modifier = Modifier) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar() {
        val bottomBar = listOf(
            BottomBarItem(title = "Beranda", icon = R.drawable.material_home, route = "home"),
            BottomBarItem(title = "Berita", icon = R.drawable.material_news, route = "news"),
            BottomBarItem(title = "Profil Saya", icon = R.drawable.material_account_circle, route = "profile")
        )

        bottomBar.forEach {
            val isSelected = currentRoute == it.route
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(painter = painterResource(it.icon), contentDescription = it.title) },
                label = { Text(text = it.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                ))
        }
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    JMOCloneTheme() {
        BottomBar(rememberNavController())
    }
}