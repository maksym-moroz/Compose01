package com.maksym.moroz.compose01.features.main.presentation.list

import com.maksym.moroz.common.domain.core.model.todo.ToDoFts

sealed interface SearchViewState {
    class Data(val value: List<ToDoFts>) : SearchViewState
    object Empty : SearchViewState
    object Invalid : SearchViewState
}