package com.example.randommammals.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

sealed interface RandomMammalScreenUiState{
    data class Success(val imageUrl: String): RandomMammalScreenUiState

    object Loading : RandomMammalScreenUiState
    data class Error(val errorMessage: String): RandomMammalScreenUiState
}

class RandomMammalScreenViewModel: ViewModel() {
    var uiState: RandomMammalScreenUiState by mutableStateOf(RandomMammalScreenUiState.Loading)
    private set

    fun getRandomMammal(){
        //TODO
    }

    fun saveMammal(){
        //TODO
    }
}