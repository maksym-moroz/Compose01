package com.maksym.moroz.compose01.features.main.data.datasource.local.room

import com.maksym.moroz.common.data.storage.dao.ToDoDao
import com.maksym.moroz.common.data.storage.dao.ToDoDaoFts
import com.maksym.moroz.common.data.storage.entity.ToDoEntity.Companion.toEntity
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.common.domain.core.model.todo.details.TaskCategory
import com.maksym.moroz.common.domain.core.model.todo.details.TaskItem
import com.maksym.moroz.common.domain.core.model.todo.details.TaskType
import com.maksym.moroz.common.domain.core.model.todo.details.ToDoId
import com.maksym.moroz.common.extensions.mapToDomain
import com.maksym.moroz.compose01.features.main.data.datasource.local.LocalDataSource
import javax.inject.Inject
import kotlin.random.Random.Default.nextInt

class RoomDataSource @Inject constructor(
    private val dao: ToDoDao,
    private val daoFts: ToDoDaoFts,
) : LocalDataSource {

    override fun loadAllItemsFlow() = dao.getAllItemsFlowDistinct()
        .mapToDomain { toDomain() }

    override suspend fun loadMatchingItemsFlow(query: String) =
        daoFts.getMatchingItemsFlowDistinct(query)
            .map { it.toDomain() }

    override suspend fun loadItemById(toDoId: ToDoId) = dao.getItemById(toDoId.id).toDomain()

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

        dao.saveItem(toDo.toEntity())
    }
}