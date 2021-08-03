package com.maksym.moroz.common.domain.core.model.user

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val showOnline: Boolean,
)
