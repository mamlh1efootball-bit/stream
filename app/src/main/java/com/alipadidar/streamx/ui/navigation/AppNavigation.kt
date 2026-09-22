package com.alipadidar.streamx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alipadidar.streamx.ui.screens.auth.AuthScreen
import com.alipadidar.streamx.ui.screens.main.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "auth") {
        composable("auth") { AuthScreen(onLogin = { navController.navigate("main") }) }
        composable("main") { MainScreen(navController = navController) }
    }
}