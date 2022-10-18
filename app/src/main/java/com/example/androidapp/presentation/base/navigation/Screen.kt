package com.example.androidapp.presentation.base.navigation

sealed class Screen(override val route: String) : NavigationDestination {
    object Home : Screen("home_screen")
}