package com.maksym.moroz.common.domain.core.model.todo

import com.maksym.moroz.common.domain.core.model.user.ToDoUser

sealed interface TaskType {
    class Usual(
        val reminder: String = "",
        val time: String = "",
        val place: String = "",
    ) : TaskType

    class Shared<out T>(
        val contributors: List<ToDoUser> = emptyList(),
        val items: List<TaskItem<T>>,
    ) : TaskType

    object Urgent : TaskType
    object Failed : TaskType
    object Missed : TaskType
}
