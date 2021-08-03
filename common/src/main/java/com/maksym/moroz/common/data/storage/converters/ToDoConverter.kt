package com.maksym.moroz.common.data.storage.converters

import androidx.room.TypeConverter
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ToDoConverter {
    @TypeConverter
    fun fromString(string: String?): ToDo? = string?.let { Json.decodeFromString(it) }

    @TypeConverter
    fun toString(toDo: ToDo?): String? = toDo?.let { Json.encodeToString(it) }
}
