package com.maksym.moroz.compose01.features.main.data.datasource.remote

import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.common.domain.core.model.todo.details.ToDoId

interface RemoteDataSource {

    suspend fun loadAllItems(): List<ToDo>

    suspend fun loadItemById(id: ToDoId): ToDo
}