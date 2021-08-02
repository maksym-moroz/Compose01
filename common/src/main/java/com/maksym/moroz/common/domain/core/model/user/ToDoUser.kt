package com.maksym.moroz.common.domain.core.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface ToDoUser : Parcelable {
    val profile: UserProfile

    @Parcelize
    class Usual(
        val preferences: UserPreferences,
        override val profile: UserProfile,
    ) : ToDoUser

    @Parcelize
    class Guest(
        override val profile: UserProfile,
    ) : ToDoUser
}
