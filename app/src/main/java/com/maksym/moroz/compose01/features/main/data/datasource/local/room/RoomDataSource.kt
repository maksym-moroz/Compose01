package com.maksym.moroz.compose01.features.main.data.datasource.local.room

import com.maksym.moroz.common.data.storage.dao.ToDoDao
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.common.domain.core.model.todo.details.TaskCategory
import com.maksym.moroz.common.domain.core.model.todo.details.TaskItem
import com.maksym.moroz.common.domain.core.model.todo.details.TaskType
import com.maksym.moroz.common.domain.core.model.todo.details.ToDoId
import com.maksym.moroz.compose01.features.main.data.datasource.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random.Default.nextInt

class RoomDataSource @Inject constructor(
    private val dao: ToDoDao,
) : LocalDataSource {

    override fun loadAllItemsFlow(): Flow<List<ToDo>> = dao.getAllItemsFlow()

    override suspend fun loadItemById(toDoId: ToDoId) = dao.getItemById(toDoId.id)

    override suspend fun saveItem(
        title: String,
        description: String,
    ) {
        val toDo = ToDo(
            nextInt(),
            TaskType.Urgent,
            TaskItem(title, description),
            TaskCategory(),
            false,
        )
        dao.saveItem(toDo)
    }
}