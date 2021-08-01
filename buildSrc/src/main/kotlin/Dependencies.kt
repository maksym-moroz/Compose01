object Dependencies {

    object Kotlin {
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES_ANDROID}"
        const val SERIALIZATION_JSON = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION_JSON}"
    }

    object Android {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
        const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"

        const val J_UNIT = "androidx.test.ext:junit:${Versions.J_UNIT}"
        const val COMPOSE_J_UNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_J_UNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

        object Ktx {
            const val CORE = "androidx.core:core-ktx:${Versions.CORE_KTX}"
            const val LIFECYCLE_ANNOTATIONS = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}"
            const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
            const val ROOM = "androidx.room:room-ktx:${Versions.ROOM}"
            const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
        }
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