package com.maksym.moroz.compose01.features.main.presentation.list

import com.maksym.moroz.common.domain.core.model.todo.ToDo

sealed interface ViewState {
    class Data(val value: List<ToDo>) : ViewState
    object Loading : ViewState
    object Nothing : ViewState
    object Empty : ViewState
    object Error : ViewState
}
