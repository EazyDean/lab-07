package com.example.lab_7

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/*
 * Replication prompt 3: Create navigation
 * Source: OpenAI Codex conversation; retrospective replication instructions.
 *
 * Create FormulaZeroApp.kt, HomeScreen.kt, UpcomingRacesScreen.kt, and
 * DriversScreen.kt. Use rememberNavController and NavHost with routes home, races,
 * and drivers. Start at home. Update MainActivity to display FormulaZeroApp inside
 * Lab7Theme.
 */

@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController()

    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.safeDrawingPadding()
        ) {
            composable("home") { HomeScreen(navController) }
            composable("races") { UpcomingRacesScreen(navController) }
            composable("drivers") { DriversScreen(navController) }
        }
    }
}
