package com.maksym.moroz.common.domain.core.model.user

sealed class UserProfile(
    val data: UserData,
    val session: UserSession,
) {
    class Usual(
        val credentials: UserCredentials,
        data: UserData,
        session: UserSession,
    ) : UserProfile(data, session)

    class Guest(
        data: UserData,
        session: UserSession,
    ) : UserProfile(data, session)
}
