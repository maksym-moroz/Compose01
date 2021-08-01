plugins {
    id("com.android.application")
    kotlin("android")
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
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.COMPOSE_UI)
    implementation(Dependencies.AndroidX.COMPOSE_MATERIAL)
    implementation(Dependencies.AndroidX.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.AndroidX.ACTIVITY_COMPOSE)
    implementation(Dependencies.AndroidX.LIFECYCLE_RUNTIME)

    androidTestImplementation(Dependencies.AndroidX.J_UNIT)
    androidTestImplementation(Dependencies.AndroidX.COMPOSE_J_UNIT)
    androidTestImplementation(Dependencies.AndroidX.ESPRESSO)

    testImplementation("junit:junit:4.+")
    debugImplementation("androidx.compose.ui:ui-tooling:1.0.0")
}