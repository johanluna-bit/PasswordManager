package com.example.passwordmanager.data.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ItemsViewModel(
    private val dao: ItemsDao
): ViewModel() {
    var state by mutableStateOf(ItemsState())
        private set

    init {
        viewModelScope.launch {
            dao.getAllItems().collectLatest {
                state = state.copy(
                    listItems = it
                )
            }
        }
    }

    fun addItem(item: Items) {
        viewModelScope.launch {
            dao.insert(item = item)
        }
    }

    fun updateItem(item: Items) {
        viewModelScope.launch {
            dao.update(item = item)
        }
    }

    fun deleteItem(item: Items) {
        viewModelScope.launch {
            dao.delete(item = item)
        }
    }

}