package com.maksym.moroz.compose01.features.main.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksym.moroz.compose01.features.main.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainDetailsViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {

    private val _title = MutableStateFlow(EMPTY_STRING)
    private val _description = MutableStateFlow(EMPTY_STRING)

    val title = _title
    val description = _description

    fun updateTitle(title: String) = viewModelScope.launch { _title.emit(title) }

    fun updateDescription(description: String) = viewModelScope.launch { _description.emit(description) }

    fun ableToSave() = _title.value.isNotEmpty() || _description.value.isNotEmpty()

    fun saveNote() {
        viewModelScope.launch {
            repository.saveItem(
                title.value,
                description.value,
            )
        }
    }

    companion object {
        const val EMPTY_STRING = ""
    }
}
