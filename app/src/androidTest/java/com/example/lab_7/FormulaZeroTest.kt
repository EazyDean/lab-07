package com.example.lab_7

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    /*
     * Replication prompt 7: Test the races flow
     * Source: OpenAI Codex conversation; retrospective replication instructions.
     *
     * Configure Compose instrumented testing. Create FormulaZeroTest.kt under
     * androidTest using createAndroidComposeRule<MainActivity>().
     *
     * Add a test that opens Upcoming Races, enters Canada, adds it, verifies it is
     * displayed and the input is cleared, presses Back, and verifies “FormulaZero Home.”
     */
    @Test
    fun navigate_to_races_add_race_and_return_home() {
        composeTestRule.onNodeWithTag("raceButton").performClick()
        composeTestRule.onNodeWithText("Upcoming Races").assertIsDisplayed()
        composeTestRule.onNodeWithTag("locationInput").performTextInput("Canada")
        composeTestRule.onNodeWithTag("addRaceButton").performClick()
        composeTestRule.onNodeWithText("Canada").assertIsDisplayed()
        composeTestRule.onNodeWithTag("locationInput").assertTextEquals("Race Location", "")
        composeTestRule.onNodeWithTag("backButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertIsDisplayed()
    }

    /*
     * Replication prompt 8: Test the drivers flow
     * Source: OpenAI Codex conversation; retrospective replication instructions.
     *
     * Add an instrumented test that opens Drivers, adds Lewis Hamilton and Max
     * Verstappen, and verifies both appear. Clear all drivers and verify both disappear
     * and the list is empty. Add Charles Leclerc to confirm adding still works. Press
     * Back and verify the home screen.
     */
    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertIsDisplayed()

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Lewis Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertIsDisplayed()
        composeTestRule.onNodeWithTag("driverInput").assertTextEquals("Driver Name", "")

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Max Verstappen")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Max Verstappen").assertIsDisplayed()

        composeTestRule.onNodeWithTag("clearDriversButton").performClick()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertDoesNotExist()
        composeTestRule.onNodeWithText("Max Verstappen").assertDoesNotExist()
        composeTestRule.onNodeWithTag("driverList").onChildren().assertCountEquals(0)

        // The list must still accept additions after it has been cleared.
        composeTestRule.onNodeWithTag("driverInput").performTextInput("Charles Leclerc")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Charles Leclerc").assertIsDisplayed()

        composeTestRule.onNodeWithTag("backButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertIsDisplayed()
    }

    /*
     * Replication prompt 9: Test blank entries
     * Source: OpenAI Codex conversation; retrospective replication instructions.
     *
     * Add an instrumented test that submits whitespace-only input on both the races
     * and drivers screens. Verify neither list receives an entry.
     */
    @Test
    fun blank_entries_are_not_added() {
        composeTestRule.onNodeWithTag("raceButton").performClick()
        composeTestRule.onNodeWithTag("locationInput").performTextInput("   ")
        composeTestRule.onNodeWithTag("addRaceButton").performClick()
        composeTestRule.onNodeWithTag("raceList").onChildren().assertCountEquals(0)
        composeTestRule.onNodeWithTag("backButton").performClick()

        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithTag("driverInput").performTextInput("   ")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithTag("driverList").onChildren().assertCountEquals(0)
    }
}
