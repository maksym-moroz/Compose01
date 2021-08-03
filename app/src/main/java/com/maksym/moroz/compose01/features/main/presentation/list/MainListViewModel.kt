package com.maksym.moroz.compose01.features.main.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.common.domain.core.model.todo.details.ToDoId
import com.maksym.moroz.compose01.features.main.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {
    private val _list = MutableStateFlow(emptyList<ToDo>())
    private val _selectedItem = MutableSharedFlow<ToDo>()

    val list: StateFlow<List<ToDo>> = _list
    val selectedItem = _selectedItem

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            repository.loadToDoListFlow()
                .distinctUntilChanged()
                .collect {
                    _list.emit(it)
                }
        }
    }

    fun loadItem(toDoId: ToDoId) {
        viewModelScope.launch {
            _selectedItem.emit(repository.loadToDoById(toDoId))
        }
    }
}
