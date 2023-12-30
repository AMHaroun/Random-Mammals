package com.example.randommammals.data

import com.example.randommammals.util.Resource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class RandomMammalsRepositoryImplTest{

    private val fakeDuckApi = FakeRandomDuckApi()
    private val fakeFoxApi = FakeRandomFoxApi()
    private val fakeTheCatApi = FakeTheCatApi()

    private val repository = RandomMammalsRepositoryImpl(
        fakeDuckApi,
        fakeFoxApi,
        fakeTheCatApi
    )

    @Test
    fun `getRandomDuck returns Success `() = runTest {

        val result = repository.getRandomDuck()

        assertThat(result is Resource.Success)

    }

    @Test
    fun `getRandomDuck returns Error when Exception is thrown`() = runTest{

        fakeDuckApi.throwNetworkErrorException()

        val result = repository.getRandomDuck()

        assertThat(result is Resource.Error)
    }

    @Test
    fun `getRandomCat returns Success`() = runTest{

        val result = repository.getRandomCat()

        assertThat(result is Resource.Success)
    }

    @Test
    fun `getRandomCat returns Error when Exception is thrown`() = runTest{

        fakeTheCatApi.throwNetworkErrorException()

        val result = repository.getRandomCat()

        assertThat(result is Resource.Error)
    }
    @Test
    fun `getRandomFox returns Success`() = runTest{

        val result = repository.getRandomFox()

        assertThat(result is Resource.Success)
    }

    @Test
    fun `getRandomFox returns Error when Exception is thrown`() = runTest{

        fakeFoxApi.throwNetworkErrorException()

        val result = repository.getRandomFox()

        assertThat(result is Resource.Error)
    }

}