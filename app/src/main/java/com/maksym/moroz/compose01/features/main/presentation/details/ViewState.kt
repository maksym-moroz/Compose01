package com.maksym.moroz.compose01.features.main.presentation.details

import com.maksym.moroz.common.domain.core.model.todo.ToDo

sealed interface ViewState {
    class Data(val value: ToDo) : ViewState
    object Loading : ViewState
    object Empty : ViewState
}
