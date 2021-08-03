package com.maksym.moroz.common.data.storage.converters

import androidx.room.TypeConverter
import com.maksym.moroz.common.domain.core.model.todo.details.TaskType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TaskTypeConverter {
    @TypeConverter
    fun fromString(string: String?): TaskType? = string?.let { Json.decodeFromString(it) }

    @TypeConverter
    fun toString(taskType: TaskType?): String? = taskType?.let { Json.encodeToString(it) }
}
