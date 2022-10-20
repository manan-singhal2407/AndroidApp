package com.example.androidapp.presentation.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.presentation.base.navigation.Navigator
import com.example.androidapp.presentation.base.navigation.Screen
import com.example.androidapp.presentation.screen.home.HomeScreen
import com.example.androidapp.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavigationCallBack(navController)
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(Screen.Home.route) {
                        HomeScreen(viewModel = hiltViewModel())
                    }
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
            val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            view.updatePadding(bottom = bottom)
            insets
        }
    }

    @Composable
    private fun NavigationCallBack(navController: NavHostController) {
        val destination by navigator.destination.collectAsState()
        LaunchedEffect(destination) {
            if (navController.currentDestination?.route != destination.route) {
                navController.navigate(destination.route) {
                    navigator.popUpTo?.let {
                        popUpTo(it.route) { inclusive = true }
                    }
                }
                navigator.popUpTo = null
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator.destination.value = Screen.Home
    }
}