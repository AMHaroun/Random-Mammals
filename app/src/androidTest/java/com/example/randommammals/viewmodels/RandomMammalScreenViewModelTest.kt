package com.example.randommammals.viewmodels

import com.example.randommammals.di.FakeRandomMammalsRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class RandomMammalScreenViewModelTest{

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: FakeRandomMammalsRepository

    private lateinit var viewModel: RandomMammalScreenViewModel
    @Before
    fun setUp(){
        hiltRule.inject()
        viewModel = RandomMammalScreenViewModel(repository)
    }

    @Test
    fun getRandomMammal_uiStateIsSuccess(){

        viewModel.getRandomMammal()

        val uiState  = viewModel.uiState

        assertTrue(uiState is RandomMammalScreenUiState.Success)
    }

    @Test
    fun getRandomMammal_networkError_uiStateIsError(){
        repository.toggleNetworkErrors()

        viewModel.getRandomMammal()

        repository.toggleNetworkErrors()

        val uiState = viewModel.uiState

        assertTrue(uiState is RandomMammalScreenUiState.Error)
    }

}