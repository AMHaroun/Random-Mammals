package com.example.randommammals.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RandomMammalsApp(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "RandomMammalScreen", modifier = modifier) {

        composable("RandomMammalScreen") {
            RandomMammalScreen()
        }
        composable("SavedMammalsScreen") {
            SavedMammalsScreen()
        }

    }
}