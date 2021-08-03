package com.maksym.moroz.common.di.db

import android.content.Context
import androidx.room.Room
import com.maksym.moroz.common.data.storage.db.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideToDoDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        "todo"
    ).build()

    @Provides
    fun provideToDoDao(database: ToDoDatabase) = database.toDoDao()
}