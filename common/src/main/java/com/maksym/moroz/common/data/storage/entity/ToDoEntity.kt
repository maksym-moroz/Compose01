package com.maksym.moroz.common.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.common.domain.core.model.todo.details.CategoryColor
import com.maksym.moroz.common.domain.core.model.todo.details.TaskCategory
import com.maksym.moroz.common.domain.core.model.todo.details.TaskItem
import com.maksym.moroz.common.domain.core.model.todo.details.TaskType

@Entity(tableName = "todo")
data class ToDoEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "category_name") val categoryName: String,
    @ColumnInfo(name = "category_color") val categoryColor: String,
    @ColumnInfo(name = "marked_as_favorite") val markedAsFavorite: Boolean,
) {

    fun toDomain() = ToDo(
        id = id,
        type = TaskType.Urgent,
        item = TaskItem(title, description),
        category = TaskCategory(categoryName, CategoryColor.valueOf(categoryColor)),
        markedAsFavorite = markedAsFavorite,
    )

    companion object {

        fun ToDo.toEntity() = ToDoEntity(
            id = id,
            title = item.title,
            description = item.description,
            categoryName = category.name,
            categoryColor = category.color.name,
            markedAsFavorite = markedAsFavorite,
        )
    }
}