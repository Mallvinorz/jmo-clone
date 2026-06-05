package com.example.jmoclone.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmoclone.R
import com.example.jmoclone.data.ServiceMenu
import com.example.jmoclone.ui.theme.JMOCloneTheme

@Composable
fun ServiceGrid(modifier: Modifier = Modifier) {
    val services = listOf(
        ServiceMenu("Info Program", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Bayar/Autodebit", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Sertakan", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Pengkinian Data", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Cek Saldo JHT", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Ajukan Klaim JHT", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Video Edukasi", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Perumahan Pekerja", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Bantuan", icon = R.drawable.material_news, onClick = {}),
        ServiceMenu("Menu Lainnya", icon = R.drawable.material_news, onClick = {}),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        userScrollEnabled = false
    ) {
        items(services) { service ->
            ServiceGridItem(service = service, onItemClick = {})
        }
    }
}

@Composable
fun ServiceGridItem(service: ServiceMenu, onItemClick: () -> Unit) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
    ) {
        Column(
            modifier = Modifier.padding(4.dp).padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(service.icon),
                contentDescription = service.title,
                modifier = Modifier.size(28.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = service.title,
                maxLines = 2,
                minLines = 2,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun ServiceGridPreview() {
    JMOCloneTheme() {
        ServiceGrid()
    }
}