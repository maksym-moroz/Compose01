package com.maksym.moroz.common.domain.core.model.user

import kotlinx.serialization.Serializable

@Serializable
sealed class UserProfile {
    abstract val data: UserData
    abstract val session: UserSession

    @Serializable
    class Usual(
        val credentials: UserCredentials,
        override val data: UserData,
        override val session: UserSession,
    ) : UserProfile()

    @Serializable
    class Guest(
        override val data: UserData,
        override val session: UserSession,
    ) : UserProfile()
}
