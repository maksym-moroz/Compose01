package com.maksym.moroz.compose01.features.main.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksym.moroz.common.domain.core.model.todo.details.ToDoId
import com.maksym.moroz.compose01.features.main.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainDetailsViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {

    val viewState = MutableStateFlow<ViewState>(ViewState.Loading)

    fun saveToDo(title: String, description: String) {
        viewModelScope.launch {
            repository.saveItem(
                title,
                description,
            )
        }
    }

    fun loadToDo(id: Int?) {
        if (id == null || id == 0) {
            viewState.value = ViewState.Empty
            return
        }

        val toDoId = ToDoId(id)
        viewModelScope.launch {
            val toDo = repository.loadToDoById(toDoId)
            viewState.value = ViewState.Data(toDo)
        }
    }
}
