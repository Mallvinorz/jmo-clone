package com.example.jmoclone.ui.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmoclone.R
import com.example.jmoclone.data.ProfileMenuItem
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun ProfileMenuList() {
    val items = listOf(
        ProfileMenuItem("Poin Saya", onClick = {}),
        ProfileMenuItem("Ubah Profil", onClick = {}),
        ProfileMenuItem("Kartu Digital Anda", onClick = {}),
        ProfileMenuItem("Informasi Autodebit", onClick = {}),
        ProfileMenuItem("Syarat dan Ketentuan", onClick = {}),
        ProfileMenuItem("Kebijakan dan Privasi", onClick = {}),
        ProfileMenuItem("Tentang Aplikasi", onClick = {})
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items.forEach { item ->
            ProfileMenuItemRow(item)
        }
    }
}

@Composable
fun ProfileMenuItemRow(item: ProfileMenuItem) {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { item.onClick() }
                .padding(vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
//            style = MaterialTheme.typography.bodyMedium,
//            color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                painter = painterResource(R.drawable.material_chevron_right),
                contentDescription = null,
//            tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        HorizontalDivider(thickness = 0.5.dp)
    }
}

@Preview
@Composable
private fun ProfileMenuListPreview() {
    JMOCloneTheme() {
        ProfileMenuList()
    }
}