package com.maksym.moroz.common.domain.core.model.todo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class TaskItem<out T>(
    val title: String = "",
    val description: String = "",
    val attachments: @RawValue List<T> = emptyList(),
) : Parcelable
