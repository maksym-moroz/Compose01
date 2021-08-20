package com.maksym.moroz.common.domain.core.model.user

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class UserData(
    val firstName: String,
    val lastName: String,
    val picture: String,
) {

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
