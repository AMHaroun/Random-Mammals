package com.example.randommammals.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randommammals.data.RandomMammalsRepository
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.Duck
import com.example.randommammals.network.responses.Fox
import com.example.randommammals.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

sealed interface RandomMammalScreenUiState{
    data class Success(val imageUrl: String): RandomMammalScreenUiState

    object Loading : RandomMammalScreenUiState
    data class Error(val errorMessage: String): RandomMammalScreenUiState
}

@HiltViewModel
class RandomMammalScreenViewModel @Inject constructor(
    private val repository: RandomMammalsRepository
): ViewModel() {

    var uiState :RandomMammalScreenUiState by mutableStateOf(RandomMammalScreenUiState.Loading)
    private set

    init {
        getRandomMammal()
    }
    fun getRandomMammal() {
        viewModelScope.launch {
            val result = when (Random.nextInt(1, 4)) {
                1 -> repository.getRandomDuck()
                2 -> repository.getRandomFox()
                3 -> repository.getRandomDuck()
                else -> throw IllegalArgumentException("Invalid random number")
            }

            when (result) {
                is Resource.Success -> {
                    uiState = RandomMammalScreenUiState.Success(
                        when (result.data) {
                            is Cat -> result.data[0].url
                            is Fox -> result.data.image
                            is Duck -> result.data.url
                            else -> throw IllegalStateException("Invalid mammal type")
                        }
                    )
                }
                is Resource.Error -> {
                    uiState = RandomMammalScreenUiState.Error(result.message)
                }
                is Resource.Loading -> {
                    uiState = RandomMammalScreenUiState.Loading
                }
            }
        }
    }

    fun saveMammal(mammalUrl: String){
        viewModelScope.launch {
            repository.saveMammal(mammalUrl)
        }
    }
}