package com.example.randommammals.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randommammals.data.RandomMammalsRepository
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
    var uiState: RandomMammalScreenUiState by mutableStateOf(RandomMammalScreenUiState.Loading)
    private set

    fun getRandomMammal(){
        when(Random.nextInt(1, 4)){
            1->{
                viewModelScope.launch {
                    val result = repository.getRandomCat()
                    when(result){
                        is Resource.Success->{
                            uiState = RandomMammalScreenUiState.Success(result.data[1].url)
                        }
                        is Resource.Error->{
                            uiState = RandomMammalScreenUiState.Error(result.message)
                        }
                        is Resource.Loading->{
                            uiState = RandomMammalScreenUiState.Loading
                        }
                    }
                }
            }
            2->{
                viewModelScope.launch {
                    val result = repository.getRandomFox()
                    when(result){
                        is Resource.Success->{
                            uiState = RandomMammalScreenUiState.Success(result.data.image)
                        }
                        is Resource.Error->{
                            uiState = RandomMammalScreenUiState.Error(result.message)
                        }
                        is Resource.Loading->{
                            uiState = RandomMammalScreenUiState.Loading
                        }
                    }
                }

            }
            3->{
                viewModelScope.launch {
                    val result = repository.getRandomFox()
                    when(result){
                        is Resource.Success->{
                            uiState = RandomMammalScreenUiState.Success(result.data.image)
                        }
                        is Resource.Error->{
                            uiState = RandomMammalScreenUiState.Error(result.message)
                        }
                        is Resource.Loading->{
                            uiState = RandomMammalScreenUiState.Loading
                        }
                    }
                }
            }
        }
    }

    fun saveMammal(){
        //TODO
    }
}