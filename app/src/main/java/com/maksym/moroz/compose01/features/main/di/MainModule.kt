package com.maksym.moroz.compose01.features.main.di

import com.maksym.moroz.compose01.features.main.data.datasource.local.LocalDataSource
import com.maksym.moroz.compose01.features.main.data.datasource.local.room.RoomDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindsModule {

    @Binds
    abstract fun bindRoomDataSource(roomDataSource: RoomDataSource): LocalDataSource
}