package com.maksym.moroz.common.domain.core.model.user

sealed class ToDoUser(val profile: UserProfile) {
    class Usual(
        val preferences: UserPreferences,
        profile: UserProfile,
    ) : ToDoUser(profile)

    class Guest(
        profile: UserProfile,
    ) : ToDoUser(profile)
}
