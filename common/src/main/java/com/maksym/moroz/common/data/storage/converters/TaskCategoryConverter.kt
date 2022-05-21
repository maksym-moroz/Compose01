package com.maksym.moroz.common.data.storage.converters

import androidx.room.TypeConverter
import com.maksym.moroz.common.domain.core.model.todo.details.TaskCategory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TaskCategoryConverter {
    @TypeConverter
    fun fromString(string: String?): TaskCategory? = string?.let { Json.decodeFromString(it) }

    @TypeConverter
    fun toString(taskCategory: TaskCategory?): String? = taskCategory?.let { Json.encodeToString(it) }
}
