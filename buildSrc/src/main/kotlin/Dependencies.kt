object Dependencies {

    object Kotlin {
        const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
        const val SERIALIZATION_JSON = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION_JSON}"
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES_ANDROID}"
    }

    object Android {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
        const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME}"
        const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"

        const val J_UNIT = "androidx.test.ext:junit:${Versions.J_UNIT}"
        const val COMPOSE_J_UNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_J_UNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }

    object Dagger {
        const val DAGGER_HILT = "com.google.dagger:hilt-android:${Versions.DAGGER_HILT}"
        const val DAGGER_HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}"
    }

    object Square {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_JSON = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.RETROFIT_JSON}"
    }
}