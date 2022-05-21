package com.maksym.moroz.compose01.features.main.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.compose01.features.main.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {
    private val _currentToDoList = MutableStateFlow<ListViewState>(ListViewState.Loading)
    private val allItems = MutableStateFlow<List<ToDo>>(emptyList())
    private val _searchQuery = MutableStateFlow("")

    val currentToDoList: StateFlow<ListViewState> = _currentToDoList
    val searchQuery: StateFlow<String> = _searchQuery

    init {
        loadItems()
    }

    fun updateQuery(query: String) = with(_currentToDoList) {
        viewModelScope.launch {
            _searchQuery
                .emit(query)
        }
        repository.loadMatchingToDoListFlow("*$query*")
            .onEach { searchList ->
                val currentList = allItems.value
                val viewState = when {
                    currentList.isEmpty() && query.isEmpty() -> ListViewState.Empty
                    searchList.isEmpty() && query.isEmpty() -> ListViewState.Data(currentList)
                    searchList.isEmpty() && query.isNotEmpty() -> ListViewState.Nothing
                    else -> ListViewState.Data(searchList)
                }
                emit(viewState)
            }
            .launchIn(viewModelScope)
    }

    private fun loadItems() = with(_currentToDoList) {
        repository.loadToDoListFlow()
            .onStart { ListViewState.Loading }
            .onEach { list ->
                allItems.emit(list)
                emit(
                    if (list.isEmpty()) ListViewState.Empty
                    else ListViewState.Data(list)
                )
            }
            .catch { emit(ListViewState.Error) }
            .launchIn(viewModelScope)
    }
}
