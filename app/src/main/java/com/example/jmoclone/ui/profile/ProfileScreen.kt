package com.example.jmoclone.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmoclone.R
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card() {
            Column() {
                Text("Name")
            }
        }
        ProfileMenuList()
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("1.0.0")
            IconTexButton({})
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
        ProfileScreen()
    }
}