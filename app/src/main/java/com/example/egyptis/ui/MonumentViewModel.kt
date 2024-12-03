package com.example.egyptis.ui

import androidx.lifecycle.ViewModel
import com.example.egyptis.data.local.LocalMonumentsDataProvider
import com.example.egyptis.data.model.Monument
import com.example.egyptis.data.model.MonumentCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MonumentViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MonumentUIState())
    val uiState: StateFlow<MonumentUIState> = _uiState.asStateFlow()

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        _uiState.value = MonumentUIState(
            monuments = LocalMonumentsDataProvider.allMonuments,
            currentMonument = LocalMonumentsDataProvider.allMonuments[0]
        )
    }

    fun updateCurrentCategory(selectedCategory: MonumentCategory) {
        _uiState.value = _uiState.value.copy(currentCategory = selectedCategory)
    }

    fun updateCurrentMonument(selectedMonument: Monument) {
        _uiState.value = _uiState.value.copy(currentMonument = selectedMonument)
    }





}