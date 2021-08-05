package com.maksym.moroz.compose01.features.main.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val _currentToDoList = MutableStateFlow<ListViewState>(ListViewState.Loading)
    private val _searchResultList = MutableStateFlow<SearchViewState>(SearchViewState.Empty)

    private val _searchQuery = MutableStateFlow("")

    val currentToDoList: StateFlow<ListViewState> = _currentToDoList
    val searchResultList: StateFlow<SearchViewState> = _searchResultList

    val searchQuery = _searchQuery

    init {
        loadItems()
    }

    fun updateQuery(query: String) = with(_searchResultList) {
        viewModelScope.launch {
            _searchQuery
                .emit(query)
        }
        repository.loadMatchingToDoListFlow("*$query*")
            .onEach { list ->
                val viewState = when {
                    list.isEmpty() && query.isNotEmpty() -> SearchViewState.Invalid
                    list.isEmpty() -> SearchViewState.Empty
                    else -> SearchViewState.Data(list)
                }
                emit(viewState)
            }
            .launchIn(viewModelScope)
    }

    private fun loadItems() = with(_currentToDoList) {
        repository.loadToDoListFlow()
            .onStart { delay(1000L) }
            .onEach { list ->
                emit(
                    if (list.isEmpty()) ListViewState.Empty
                    else ListViewState.Data(list)
                )
            }
            .catch { emit(ListViewState.Error) }
            .launchIn(viewModelScope)
    }
}
