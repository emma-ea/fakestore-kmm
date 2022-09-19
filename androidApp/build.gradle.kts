plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.emma_ea.fakestore.android"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
        targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    // Integration with activities
    implementation ("androidx.activity:activity-compose:1.5.1")
    // Compose Material Design
    implementation ("androidx.compose.material:material:1.2.1")
    // Animations
    implementation ("androidx.compose.animation:animation:1.2.1")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-tooling:1.2.1")
    // Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // UI Tests
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.2.1")

    // When using a MDC theme
    implementation ("com.google.android.material:compose-theme-adapter:1.1.16")
    // When using a AppCompat theme
    implementation ("com.google.accompanist:accompanist-appcompat-theme:0.25.1")
    val nav_version = "2.5.2"
    implementation("androidx.navigation:navigation-compose:$nav_version")

}