package com.maksym.moroz.common.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maksym.moroz.common.data.storage.entity.ToDoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class ToDoDao {

    @Query("SELECT * FROM todo")
    abstract fun getAllItemsFlow(): Flow<List<ToDoEntity>>

    @Query("SELECT * FROM todo WHERE rowid = :id")
    abstract suspend fun getItemById(id: Int): ToDoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveAll(items: List<ToDoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveItem(item: ToDoEntity)

    fun getAllItemsFlowDistinct() = getAllItemsFlow().distinctUntilChanged()
}
