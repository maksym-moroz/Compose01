package com.maksym.moroz.common.domain.core.model.todo

import android.os.Parcelable
import com.maksym.moroz.common.CategoryColor
import kotlinx.parcelize.Parcelize

@Parcelize
data class TaskCategory(
    val category: String = "Reminders",
    val color: CategoryColor = CategoryColor.LIGHT_GRAY,
) : Parcelable