plugins {
    id("com.android.library")
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
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK_VERSION

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
                arg("room.incremental", "true")
            }
        }

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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(Dependencies.Kotlin.SERIALIZATION_JSON)
    api(Dependencies.Kotlin.COROUTINES_ANDROID)
    api(Dependencies.AndroidX.Ktx.CORE)
    api(Dependencies.AndroidX.Ktx.ROOM)
    api(Dependencies.AndroidX.Ktx.DATASTORE_COMMON)
    api(Dependencies.Dagger.DAGGER_HILT)
    api(Dependencies.Square.RETROFIT)
    api(Dependencies.Square.RETROFIT_JSON)

    kapt(Dependencies.AndroidX.ROOM_COMPILER)
    kapt(Dependencies.Dagger.DAGGER_HILT_COMPILER)

    androidTestImplementation(Dependencies.AndroidX.J_UNIT)
    androidTestImplementation(Dependencies.AndroidX.ESPRESSO)

    testApi("junit:junit:4.+")
}

kapt {
    correctErrorTypes = true
}