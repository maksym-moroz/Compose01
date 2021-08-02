package com.maksym.moroz.common.domain.core.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserSession(
    val sessionId: String?,
) : Parcelable
