package com.maksym.moroz.common.data.storage.dao

import androidx.room.Dao
import androidx.room.Query
import com.maksym.moroz.common.data.storage.entity.ToDoEntityFts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class ToDoDaoFts {

    @Query("SELECT * FROM todo_fts WHERE todo_fts MATCH :query")
    abstract fun getMatchingItemsFlow(query: String): Flow<List<ToDoEntityFts>>

    fun getMatchingItemsFlowDistinct(query: String) =
        getMatchingItemsFlow(query).distinctUntilChanged()
}
