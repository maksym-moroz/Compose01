package com.maksym.moroz.common.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ToDoDao {

    @Query("SELECT * FROM todo")
    abstract fun getAllItemsFlow(): Flow<List<ToDo>>

    @Query("SELECT * FROM todo WHERE id = :id")
    abstract suspend fun getItemById(id: Int): ToDo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveAll(items: List<ToDo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveItem(item: ToDo)
}
