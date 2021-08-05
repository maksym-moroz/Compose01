package com.maksym.moroz.compose01.features.main.presentation.list

import com.maksym.moroz.common.domain.core.model.todo.ToDo

sealed interface ListViewState {
    class Data(val value: List<ToDo>) : ListViewState
    object Loading : ListViewState
    object Empty : ListViewState
    object Error : ListViewState
}