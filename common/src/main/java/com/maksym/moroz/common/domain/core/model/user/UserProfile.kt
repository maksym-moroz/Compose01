package com.maksym.moroz.common.domain.core.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface UserProfile : Parcelable {
    val data: UserData
    val session: UserSession

    @Parcelize
    class Usual(
        val credentials: UserCredentials,
        override val data: UserData,
        override val session: UserSession,
    ) : UserProfile

    @Parcelize
    class Guest(
        override val data: UserData,
        override val session: UserSession,
    ) : UserProfile
}
