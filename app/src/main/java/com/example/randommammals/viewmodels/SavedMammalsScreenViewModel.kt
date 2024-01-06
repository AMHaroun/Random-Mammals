package com.example.randommammals.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randommammals.data.RandomMammalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SavedMammalsScreenUiState(val savedMammals: List<String>)

@HiltViewModel
class SavedMammalsScreenViewModel @Inject constructor(
    private val repository: RandomMammalsRepository
): ViewModel() {

    var uiState: SavedMammalsScreenUiState by mutableStateOf(SavedMammalsScreenUiState(listOf()))
    private set
    fun getSavedMammals(){
        viewModelScope.launch {
            repository.getMammals().collect{ mammals ->
                uiState = SavedMammalsScreenUiState(savedMammals = mammals.map { it.url })
            }
        }
    }
}