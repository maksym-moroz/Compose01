package com.maksym.moroz.common.domain.core.model.user

import kotlinx.serialization.Serializable

@Serializable
sealed class ToDoUser {
    abstract val profile: UserProfile

    @Serializable
    class Usual(
        val preferences: UserPreferences,
        override val profile: UserProfile,
    ) : ToDoUser()

    @Serializable
    class Guest(
        override val profile: UserProfile,
    ) : ToDoUser()
}
