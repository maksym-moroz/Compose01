package com.maksym.moroz.common.domain.core.model.todo

data class ToDo<out T>(
    val type: TaskType,
    val item: TaskItem<T>,
    val category: TaskCategory,
    val isFavorite: Boolean,
)
