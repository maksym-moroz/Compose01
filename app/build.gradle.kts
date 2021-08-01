plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.COMPILE_SDK_VERSION
    buildToolsVersion = Config.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = Config.APPLICATION_ID
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK_VERSION
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME
        testInstrumentationRunner = Config.ANDROID_TEST_INSTRUMENTATION

        vectorDrawables {
            useSupportLibrary = true
        }
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Dependencies.Kotlin.STD_LIB)
    implementation(Dependencies.Kotlin.SERIALIZATION_JSON)
    implementation(Dependencies.Kotlin.COROUTINES_ANDROID)
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.COMPOSE_UI)
    implementation(Dependencies.AndroidX.COMPOSE_MATERIAL)
    implementation(Dependencies.AndroidX.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.AndroidX.ACTIVITY_COMPOSE)
    implementation(Dependencies.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependencies.AndroidX.ROOM)
    implementation(Dependencies.AndroidX.ROOM_KTX)
    implementation(Dependencies.Dagger.DAGGER_HILT)
    implementation(Dependencies.Square.RETROFIT)
    implementation(Dependencies.Square.RETROFIT_JSON)

    kapt(Dependencies.AndroidX.ROOM_COMPILER)
    kapt(Dependencies.Dagger.DAGGER_HILT_COMPILER)

    androidTestImplementation(Dependencies.AndroidX.J_UNIT)
    androidTestImplementation(Dependencies.AndroidX.COMPOSE_J_UNIT)
    androidTestImplementation(Dependencies.AndroidX.ESPRESSO)

    testImplementation("junit:junit:4.+")
    debugImplementation("androidx.compose.ui:ui-tooling:1.0.0")
}

kapt {
    correctErrorTypes = true
}