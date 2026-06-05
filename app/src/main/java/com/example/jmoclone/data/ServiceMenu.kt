package com.example.jmoclone.data

data class ServiceMenu(
    val title: String,
    val icon: Int,
    val onClick: () -> Unit
)
