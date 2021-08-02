package com.maksym.moroz.common.domain.core.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class UserCredentials(
    val login: String,
    val password: String,
    val uuid: UUID,
    val isVerified: Boolean = false,
) : Parcelable