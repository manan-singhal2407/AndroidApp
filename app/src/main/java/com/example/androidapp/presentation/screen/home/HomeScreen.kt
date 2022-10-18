package com.example.androidapp.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Add new match")
        Text(text = "Add new match")
        Text(text = "Add new match")
        Text(text = "Add new match")
        Text(text = "Add new match")
        Text(text = "Add new match")
        Text(text = "Add new match")
    }
}