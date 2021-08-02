package com.maksym.moroz.common.domain.core.model.todo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDo<out T>(
    val type: TaskType,
    val item: TaskItem<T>,
    val category: TaskCategory,
    val isFavorite: Boolean,
) : Parcelable
