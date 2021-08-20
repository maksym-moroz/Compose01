package com.maksym.moroz.common.domain.core.model.user

import kotlinx.serialization.Serializable

@Serializable
data class UserSession(
    val sessionId: String?,
)
