package com.maksym.moroz.compose01.features.main.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksym.moroz.common.domain.core.model.todo.ToDo
import com.maksym.moroz.compose01.features.main.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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
    private var allItems = emptyList<ToDo>()
    private val currentToDoList = MutableStateFlow<ViewState>(ViewState.Loading)

    init {
        loadItems()
    }

    fun updateQuery(query: String): StateFlow<ViewState> {
        viewModelScope.launch {
            val searchList = repository.loadMatchingToDoListFlow(query)
            val currentList = allItems
            val resultList = when {
                currentList.isEmpty() && query.isEmpty() -> ViewState.Empty
                searchList.isEmpty() && query.isEmpty() -> ViewState.Data(currentList)
                searchList.isEmpty() && query.isNotEmpty() -> ViewState.Nothing
                else -> ViewState.Data(searchList)
            }
            currentToDoList.value = resultList
        }
        return currentToDoList
    }

    private fun loadItems() = with(currentToDoList) {
        repository.loadToDoListFlow()
            .onStart { delay(500L) }
            .onEach { list ->
                allItems = list
                value = if (list.isEmpty()) ViewState.Empty else ViewState.Data(list)
            }
            .catch { value = ViewState.Error }
            .launchIn(viewModelScope)
    }
}
