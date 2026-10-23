# CMPUT 301: Lab 7 Participation Exercise

<!--
Replication prompt 10: Update the documentation
Source: OpenAI Codex conversation; retrospective replication instructions.

Update README.md with:
- Full name: Dean Elbery
- CCID: delbery
- Student collaborators: none
- References to the lab materials and Android documentation
- Disclosure of OpenAI Codex assistance
- Build and test commands
- A note that lists reset when leaving a screen

Update the copyright name in LICENSE.md to Dean Elbery. Preserve the remaining
license text.
-->

## Student Details
- **Full Name:** Dean Elbery
- **CCID:** `delbery`

## References and Resources
- [Lab 7 description](lab-07-description.md) and CMPUT 301 Lab 7 slides, *Navigation and UI Testing* (2026).
- [Android navigation with Compose](https://developer.android.com/develop/ui/compose/navigation).
- [Compose UI testing](https://developer.android.com/develop/ui/compose/testing).
- [Navigation release notes](https://developer.android.com/jetpack/androidx/releases/navigation).
- OpenAI Codex (implementation and verification support).

## Verbal Collaboration
N/A

## Android Project

Open this repository in Android Studio and sync Gradle. The Kotlin / Jetpack
Compose app includes the walkthrough and participation exercise:

- Home navigates to Upcoming Races and FormulaZero Drivers.
- Upcoming Races accepts nonblank locations and displays them in a list.
- Drivers accepts nonblank names, displays them in a list, and clears all drivers.
- Both screens have a Back button that returns home.

Lists use in-memory Compose state. Leaving a screen resets its list; data
persistence is optional in this lab.

Build the app and instrumented tests:

```shell
./gradlew assembleDebug assembleDebugAndroidTest lintDebug
```

Run the Compose UI tests with an Android emulator or physical device connected:

```shell
./gradlew connectedDebugAndroidTest
```

`FormulaZeroTest` covers the walkthrough race flow, adding multiple drivers,
clearing the list, adding after clearing, returning home, and rejecting blank
race locations and driver names.

<!--
Replication prompt 11: Verify the project
Source: OpenAI Codex conversation; retrospective replication instructions.

Build the debug app and instrumented test APK. Run lint and all three UI tests on
an Android emulator. Preserve existing emulator data; never use -wipe-data. Fix
failures and rerun affected checks. Launch the app for a visual check, and record
actual verification results in the README.
-->

## Verification

- Debug app and instrumented test APKs build successfully.
- All 3 instrumented UI tests passed on `Medium_Phone_API_36` (Android 16).
- `lintDebug` passes with no errors; remaining warnings concern newer SDK and
  dependency versions. Navigation 2.9.8 follows the lab description.

Submit this repository's URL on Canvas after reviewing the completed project.

## Replication Prompt References

Prompts 2–11 from the OpenAI Codex conversation are recorded as comments beside
the relevant implementation or documentation. These prompts were written after
the implementation as instructions to reproduce it.

| Prompt | Location |
| --- | --- |
| 2: Project setup | [App Gradle configuration](app/build.gradle.kts) |
| 3: Navigation | [FormulaZeroApp](app/src/main/java/com/example/lab_7/FormulaZeroApp.kt) |
| 4: Home screen | [HomeScreen](app/src/main/java/com/example/lab_7/HomeScreen.kt) |
| 5: Races screen | [UpcomingRacesScreen](app/src/main/java/com/example/lab_7/UpcomingRacesScreen.kt) |
| 6: Drivers screen | [DriversScreen](app/src/main/java/com/example/lab_7/DriversScreen.kt) |
| 7: Race test | [FormulaZeroTest](app/src/androidTest/java/com/example/lab_7/FormulaZeroTest.kt), above the race test |
| 8: Drivers test | [FormulaZeroTest](app/src/androidTest/java/com/example/lab_7/FormulaZeroTest.kt), above the drivers test |
| 9: Blank input test | [FormulaZeroTest](app/src/androidTest/java/com/example/lab_7/FormulaZeroTest.kt), above the blank input test |
| 10: Documentation | HTML comment above Student Details in this README; also covers LICENSE.md |
| 11: Verification | HTML comment above Verification in this README |
