package com.maksym.moroz.common.domain.core.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class UserData(
    val firstName: String,
    val lastName: String,
    val picture: String,
) : Parcelable {
    companion object {
        private const val SEED = 42

        private val random by lazy(LazyThreadSafetyMode.NONE) {
            Random(SEED)
        }

        private val firstNames by lazy(LazyThreadSafetyMode.NONE) {
            listOf(
                "Happy",
                "Sad",
                "Grumpy",
            )
        }
        private val lastNames by lazy(LazyThreadSafetyMode.NONE) {
            listOf(
                "Feet",
                "Fingers",
                "Eyes",
            )
        }
        private val pictures by lazy(LazyThreadSafetyMode.NONE) {
            listOf(
                TODO()
            )
        }

        fun guestUser() = generateGuestUser()

        private fun generateGuestUser() = UserData(
            firstName = firstNames.random(random),
            lastName = lastNames.random(random),
            picture = pictures.random(random),
        )
    }
}
