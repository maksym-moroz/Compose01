package com.maksym.moroz.common.domain.core.model.todo

import android.os.Parcelable
import com.maksym.moroz.common.domain.core.model.user.ToDoUser
import kotlinx.parcelize.Parcelize

sealed interface TaskType : Parcelable {

    @Parcelize
    class Usual(
        val reminder: String = "",
        val time: String = "",
        val place: String = "",
    ) : TaskType

    @Parcelize
    class Shared<out T>(
        val contributors: List<ToDoUser> = emptyList(),
        val items: List<TaskItem<T>>,
    ) : TaskType

    @Parcelize object Urgent : TaskType
    @Parcelize object Failed : TaskType
    @Parcelize object Missed : TaskType
}
