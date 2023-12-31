package com.example.randommammals.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.randommammals.data.RandomMammalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

sealed interface RandomMammalScreenUiState{
    data class Success(val imageUrl: String): RandomMammalScreenUiState

    object Loading : RandomMammalScreenUiState
    data class Error(val errorMessage: String): RandomMammalScreenUiState
}

@HiltViewModel
class RandomMammalScreenViewModel @Inject constructor(
    private val repository: RandomMammalsRepository
): ViewModel() {
    var uiState: RandomMammalScreenUiState by mutableStateOf(RandomMammalScreenUiState.Loading)
    private set

    fun getRandomMammal(){

    }

    fun saveMammal(){
        //TODO
    }
}