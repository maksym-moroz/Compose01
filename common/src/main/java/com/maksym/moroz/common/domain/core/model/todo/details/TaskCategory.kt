package com.maksym.moroz.common.domain.core.model.todo.details

import kotlinx.serialization.Serializable

@Serializable
data class TaskCategory(
    val category: String = "Reminders",
    val color: CategoryColor = CategoryColor.LIGHT_GRAY,
)