# Trivia Educational LSPosed / Vector Module

Modernized Android module template compatible with current LSPosed-style and Vector-style legacy Xposed module loading.

## Status

- Android Gradle Plugin: 8.13.1
- Gradle wrapper: 8.14.3
- Java: 21
- compileSdk / targetSdk: 36
- minSdk: 31 (Android 12)
- Legacy Xposed API: compileOnly `de.robv.android.xposed:api:82`
- Runtime target: Android 12-16 devices using LSPosed-compatible or Vector-compatible framework builds.

## Safety note

The original public PoC targeted an old third-party game package. This modernization intentionally removes that behavior and ships as a safe educational template. The included hook only observes `Application.onCreate` for the placeholder package:

```text
com.saulozt.trivia.demo
```

Replace that package only with an app you own or a local demo app.

## Build locally

```powershell
.\gradlew.bat assembleRelease
```

Output:

```text
app/build/outputs/apk/release/app-release-unsigned.apk
```

For device install/testing, sign the APK with your own debug/release key.
