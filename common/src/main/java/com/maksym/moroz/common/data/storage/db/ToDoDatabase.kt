package com.maksym.moroz.common.data.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maksym.moroz.common.data.storage.dao.ToDoDao
import com.maksym.moroz.common.data.storage.dao.ToDoDaoFts
import com.maksym.moroz.common.data.storage.entity.ToDoEntity
import com.maksym.moroz.common.data.storage.entity.ToDoEntityFts

@Database(
    version = 1,
    entities = [ToDoEntity::class, ToDoEntityFts::class],
    exportSchema = true,
)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    abstract fun toDoDaoFts(): ToDoDaoFts
}