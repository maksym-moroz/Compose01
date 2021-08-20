package com.maksym.moroz.common.domain.core.model.todo.details

import com.maksym.moroz.common.domain.core.model.user.ToDoUser
import kotlinx.serialization.Serializable

@Serializable
sealed class TaskType {

    @Serializable
    class Usual(
        val reminder: String = "",
        val time: String = "",
        val place: String = "",
    ) : TaskType()

    @Serializable
    class Shared(
        val contributors: List<ToDoUser> = emptyList(),
        val items: List<TaskItem>,
    ) : TaskType()

    @Serializable
    object Urgent : TaskType()

    @Serializable
    object Failed : TaskType()

    @Serializable
    object Missed : TaskType()
}
