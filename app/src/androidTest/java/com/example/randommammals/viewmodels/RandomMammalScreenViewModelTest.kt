package com.example.randommammals.viewmodels

import com.example.randommammals.data.RandomMammalsRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

@HiltAndroidTest
class RandomMammalScreenViewModelTest{

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: RandomMammalsRepository

    private lateinit var viewModel: RandomMammalScreenViewModel
    @Before
    fun setUp(){
        hiltRule.inject()
        viewModel = RandomMammalScreenViewModel(repository)
    }

}