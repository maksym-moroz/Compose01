package com.maksym.moroz.common.domain.core.model.todo.details

import kotlinx.serialization.Serializable

@Serializable
data class TaskItem(
    val title: String = "",
    val description: String = "",
    val attachments: List<ItemContainer> = listOf(),
)
