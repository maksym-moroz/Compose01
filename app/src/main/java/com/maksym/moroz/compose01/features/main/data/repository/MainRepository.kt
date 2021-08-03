package com.maksym.moroz.compose01.features.main.data.repository

import com.maksym.moroz.common.di.dispatchers.IoDispatcher
import com.maksym.moroz.common.domain.core.model.todo.details.ToDoId
import com.maksym.moroz.compose01.features.main.data.datasource.local.LocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    localDataSource: LocalDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) {
    private val dataSources = listOf(
        localDataSource,
    )

    fun loadToDoListFlow() = dataSources.first().loadAllItemsFlow()

    suspend fun loadToDoById(toDoId: ToDoId) = withContext(dispatcher) {
        dataSources.first().loadItemById(toDoId)
    }

    suspend fun saveItem(
        title: String,
        description: String,
    ) = withContext(dispatcher) {
        dataSources.first().saveItem(title, description)
    }
}
