package com.maksym.moroz.common.data.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maksym.moroz.common.data.storage.converters.TaskCategoryConverter
import com.maksym.moroz.common.data.storage.converters.TaskItemConverter
import com.maksym.moroz.common.data.storage.converters.TaskTypeConverter
import com.maksym.moroz.common.data.storage.converters.ToDoConverter
import com.maksym.moroz.common.data.storage.dao.ToDoDao
import com.maksym.moroz.common.domain.core.model.todo.ToDo

@Database(
    version = 1,
    entities = [ToDo::class],
    exportSchema = true,
)
@TypeConverters(
    ToDoConverter::class,
    TaskTypeConverter::class,
    TaskItemConverter::class,
    TaskCategoryConverter::class,
)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao
}