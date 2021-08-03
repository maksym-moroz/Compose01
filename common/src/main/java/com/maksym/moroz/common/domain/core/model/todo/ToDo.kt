package com.maksym.moroz.common.domain.core.model.todo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maksym.moroz.common.domain.core.model.todo.details.TaskCategory
import com.maksym.moroz.common.domain.core.model.todo.details.TaskItem
import com.maksym.moroz.common.domain.core.model.todo.details.TaskType
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "todo")
data class ToDo(
    @PrimaryKey val id: Int,
    val type: TaskType,
    val item: TaskItem,
    val category: TaskCategory,
    val favorite: Boolean,
)
