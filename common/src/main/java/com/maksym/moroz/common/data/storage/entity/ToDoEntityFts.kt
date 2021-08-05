package com.maksym.moroz.common.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4

@Fts4(contentEntity = ToDoEntity::class)
@Entity(tableName = "todo_fts")
data class ToDoEntityFts(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
)