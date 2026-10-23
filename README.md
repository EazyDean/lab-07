# CMPUT 301: Lab 7 Participation Exercise

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

## Verification

- Debug app and instrumented test APKs build successfully.
- All 3 instrumented UI tests passed on `Medium_Phone_API_36` (Android 16).
- `lintDebug` passes with no errors; remaining warnings concern newer SDK and
  dependency versions. Navigation 2.9.8 follows the lab description.

Submit this repository's URL on Canvas after reviewing the completed project.
