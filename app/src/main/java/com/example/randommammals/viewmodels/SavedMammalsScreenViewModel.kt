package com.example.randommammals.viewmodels

import androidx.lifecycle.ViewModel
import com.example.randommammals.data.RandomMammalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class SavedMammalsScreenUiState(val savedMammals: List<String>)

@HiltViewModel
class SavedMammalsScreenViewModel @Inject constructor(
    private val repository: RandomMammalsRepository
): ViewModel() {

    fun getSavedMammals(){
        //TODO
    }
}