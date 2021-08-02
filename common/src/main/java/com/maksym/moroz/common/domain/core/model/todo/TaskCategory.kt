package com.maksym.moroz.common.domain.core.model.todo

import com.maksym.moroz.common.CategoryColor

data class TaskCategory(
    val category: String = "Reminders",
    val color: CategoryColor = CategoryColor.LIGHT_GRAY,
)