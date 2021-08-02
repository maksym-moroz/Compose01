package com.maksym.moroz.common.domain.core.model.todo

data class TaskItem<out T>(
    val title: String = "",
    val description: String = "",
    val attachments: List<T> = emptyList(),
)
