package com.maksym.moroz.common.data.storage.converters

import androidx.room.TypeConverter
import com.maksym.moroz.common.domain.core.model.todo.details.TaskItem
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TaskItemConverter {
    @TypeConverter
    fun fromString(string: String?): TaskItem? = string?.let { Json.decodeFromString(it) }

    @TypeConverter
    fun toString(taskItem: TaskItem?): String? = taskItem?.let { Json.encodeToString(it) }
}
