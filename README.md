# MAD Practical 3 – Implicit & Explicit Intent

**Enrollment No.:** 24012021063  
**Repository:** `24012021063_MAD_practical_3`

## AIM

Create an Android application that demonstrates **Implicit Intent** and **Explicit Intent**.

## Practical Description

This practical demonstrates how Android Intents can be used to communicate with other Android applications/components and to navigate between activities.

The application provides buttons for the following operations:

1. Make a call to a specific number
2. Open a specific URL
3. Open the Call Log
4. Open the Gallery
5. Set an Alarm
6. Open the Camera
7. Open the Login Activity

## Concepts Studied

- Intent
- Explicit Intent
- Implicit Intent
- Intent Actions
- `Intent.setData()`
- `Intent.setType()`
- `startActivity()`
- `ActivityResultContracts`
- Runtime permissions
- `ContextCompat.checkSelfPermission()`
- `ActivityCompat.requestPermissions()`
- `Uri.parse()`
- `ConstraintLayout`
- `CoordinatorLayout`
- Android Manifest permissions
- `ContactsContract.Contacts.CONTENT_TYPE`
- `CallLog.Calls.CONTENT_TYPE`
- `image/*`
- `tel:`

## Implicit Intent vs Explicit Intent

### Implicit Intent

An implicit intent does not specify a particular application/component. Instead, it describes the action to be performed, and Android finds a suitable application to handle it.

Examples used in this practical:

- Opening a web URL
- Opening the Call Log
- Opening the Gallery
- Setting an Alarm
- Opening the Camera
- Making a phone call

Typical examples:

```kotlin
Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
```

```kotlin
Intent(Intent.ACTION_VIEW, Uri.parse("tel:9876543210"))
```

### Explicit Intent

An explicit intent specifies the exact activity/component that should be opened.

This practical uses an explicit intent to open the Login Activity:

```kotlin
val intent = Intent(this, loginActivity::class.java)
startActivity(intent)
```

## Features

### 1. Make Call

Uses the `tel:` URI scheme to open the phone/dialer application for a specific number.

Example:

```kotlin
val intent = Intent(Intent.ACTION_DIAL)
intent.data = Uri.parse("tel:9876543210")
startActivity(intent)
```

> If the application directly places a call using `ACTION_CALL`, the required `CALL_PHONE` permission must be declared and granted at runtime.

### 2. Open Specific URL

Uses `ACTION_VIEW` with a URL.

```kotlin
val intent = Intent(Intent.ACTION_VIEW)
intent.data = Uri.parse("https://www.google.com")
startActivity(intent)
```

Android opens the available browser application.

### 3. Open Call Log

Uses the Call Log content type to request the device's call-log application.

```kotlin
val intent = Intent(Intent.ACTION_VIEW)
intent.type = CallLog.Calls.CONTENT_TYPE
startActivity(intent)
```

Depending on the Android version and installed applications, the system may ask which application should handle the intent.

### 4. Open Gallery

Uses `ACTION_VIEW` and the MIME type `image/*` to open an application capable of displaying images.

```kotlin
val intent = Intent(Intent.ACTION_VIEW)
intent.type = "image/*"
startActivity(intent)
```

### 5. Set Alarm

Uses Android's alarm intent action to open the alarm interface.

```kotlin
val intent = Intent(AlarmClock.ACTION_SET_ALARM)
intent.putExtra(AlarmClock.EXTRA_HOUR, 7)
intent.putExtra(AlarmClock.EXTRA_MINUTES, 0)
startActivity(intent)
```

### 6. Open Camera

Uses the camera intent.

```kotlin
val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
startActivity(intent)
```

For camera-related operations, the required permission should be handled according to the implementation and Android version.

### 7. Open Login Activity

Uses an explicit intent to move from `MainActivity` to `loginActivity`.

```kotlin
val intent = Intent(this, loginActivity::class.java)
startActivity(intent)
```

## Permission Handling

Some Android operations require permissions. Permissions should be declared in `AndroidManifest.xml` and, for dangerous permissions, requested at runtime when required.

Example:

```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.CALL_PHONE" />
```

Runtime permission checking can be performed using:

```kotlin
ContextCompat.checkSelfPermission()
```

and permission requests can be made using:

```kotlin
ActivityCompat.requestPermissions()
```

The application should check permission status before performing an operation that requires a dangerous permission.

## ActivityResultContracts

`ActivityResultContracts` provides a modern way to launch activities and receive their results.

For example, an activity result launcher can be registered and then used to launch another activity:

```kotlin
val launcher = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
) {
    // Handle returned result here
}
```

## Project Structure

```text
24012021063_MAD_practical_3/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/a24012021063_mad_practical_3/
│   │       │       ├── MainActivity.kt
│   │       │       └── loginActivity.kt
│   │       │
│   │       ├── res/
│   │       │   └── layout/
│   │       │
│   │       └── AndroidManifest.xml
│   │
│   └── build.gradle.kts
│
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

The repository currently contains the `app` module and the main source package includes `MainActivity.kt` and `loginActivity.kt`. citeturn0view0turn3view0turn3view1

## Requirements

- Android Studio
- Android SDK
- Kotlin
- Gradle
- Android emulator or physical Android device

## How to Run

1. Clone or download the repository.
2. Open the project in Android Studio.
3. Allow Gradle to sync completely.
4. Connect an Android device or start an emulator.
5. Enable required permissions when prompted.
6. Click **Run ▶**.
7. Test each button from the main screen.

## Expected Result

The application successfully demonstrates:

- Communication with external Android applications using implicit intents.
- Navigation between activities using an explicit intent.
- Use of URI schemes and MIME types.
- Runtime permission handling.
- Launching system applications such as the browser, dialer, call log, gallery, alarm, and camera.

## Conclusion

Thus, an Android application demonstrating **Implicit Intent and Explicit Intent** was successfully implemented. The practical provides hands-on understanding of Android Intent actions, `setData()`, `setType()`, `Uri.parse()`, permissions, `startActivity()`, `ActivityResultContracts`, and activity navigation.
