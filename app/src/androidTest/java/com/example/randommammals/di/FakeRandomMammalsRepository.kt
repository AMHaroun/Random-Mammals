package com.example.randommammals.di

import com.example.randommammals.data.RandomMammalsRepository
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.Duck
import com.example.randommammals.network.responses.Fox
import com.example.randommammals.util.Resource

class FakeRandomMammalsRepository: RandomMammalsRepository{

    private val duckApi = FakeRandomDuckApi()
    private val foxApi = FakeRandomFoxApi()
    private val theCatApi = FakeTheCatApi()
    override suspend fun getRandomDuck(): Resource<Duck> {
        val result = try {
            duckApi.getRandomDuck()
        } catch (e: Exception){
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }

    override suspend fun getRandomCat(): Resource<Cat> {
        val result = try {
            theCatApi.getRandomCat()
        } catch (e: Exception){
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }

    override suspend fun getRandomFox(): Resource<Fox> {
        val result = try {
            foxApi.getRandomFox()
        } catch (e: Exception){
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }

    fun toggleNetworkErrors(){
        duckApi.toggleNetworkErrorException()
        foxApi.toggleNetworkErrorException()
        theCatApi.toggleNetworkErrorException()
    }
}