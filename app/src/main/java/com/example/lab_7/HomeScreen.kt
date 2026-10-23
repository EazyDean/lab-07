package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/*
 * Replication prompt 4: Build the home screen
 * Source: OpenAI Codex conversation; retrospective replication instructions.
 *
 * Implement HomeScreen with the centered title “FormulaZero Home” and buttons for
 * “Upcoming Races” and “Drivers.” Make each button navigate to its screen. Use test
 * tags raceButton and driversButton.
 */

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("FormulaZero Home", fontSize = 24.sp)
        Button(
            onClick = { navController.navigate("races") },
            modifier = Modifier.testTag("raceButton")
        ) {
            Text("Upcoming Races")
        }
        Button(
            onClick = { navController.navigate("drivers") },
            modifier = Modifier.testTag("driversButton")
        ) {
            Text("Drivers")
        }
    }
}
