package com.example.randommammals.viewmodels

import com.example.randommammals.di.FakeRandomMammalsRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getRandomMammal_uiStateIsSuccess() = runTest{

        val dispatcher = StandardTestDispatcher()

        Dispatchers.setMain(dispatcher)

        viewModel.getRandomMammal()

        dispatcher.scheduler.advanceUntilIdle()

        val uiState  = viewModel.uiState
        assertTrue(uiState is RandomMammalScreenUiState.Success)

        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getRandomMammal_networkError_uiStateIsError() = runTest{
        repository.toggleNetworkErrors()

        val dispatcher = StandardTestDispatcher()

        Dispatchers.setMain(dispatcher)

        viewModel.getRandomMammal()

        dispatcher.scheduler.advanceUntilIdle()


        repository.toggleNetworkErrors()

        val uiState = viewModel.uiState

        assertTrue(uiState is RandomMammalScreenUiState.Error)

        Dispatchers.resetMain()
    }

}