package com.maksym.moroz.compose01.features.main.data.datasource.local

import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.common.domain.core.model.todo.details.ToDoId
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun loadAllItemsFlow(): Flow<List<ToDo>>

    suspend fun loadMatchingItemsFlow(query: String): List<ToDo>

    suspend fun loadItemById(toDoId: ToDoId): ToDo

    suspend fun saveItem(
        title: String,
        description: String,
    )
}
