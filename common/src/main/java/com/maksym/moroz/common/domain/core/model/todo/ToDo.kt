package com.maksym.moroz.common.domain.core.model.todo

import com.maksym.moroz.common.domain.core.model.todo.details.TaskCategory
import com.maksym.moroz.common.domain.core.model.todo.details.TaskItem
import com.maksym.moroz.common.domain.core.model.todo.details.TaskType

data class ToDo(
    val id: Int,
    val type: TaskType,
    val item: TaskItem,
    val category: TaskCategory,
    val markedAsFavorite: Boolean,
)
