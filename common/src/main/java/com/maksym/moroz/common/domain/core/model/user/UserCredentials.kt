package com.maksym.moroz.common.domain.core.model.user

import kotlinx.serialization.Serializable

@Serializable
data class UserCredentials(
    val login: String,
    val password: String,
    val uuid: String,
    val isVerified: Boolean = false,
)