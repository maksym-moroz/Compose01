package com.maksym.moroz.common.domain.core.model.user

import java.util.*

data class UserCredentials(
    val login: String,
    val password: String,
    val uuid: UUID,
    val isVerified: Boolean = false,
)