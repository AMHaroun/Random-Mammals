package com.example.randommammals.data

import com.example.randommammals.network.RandomDuckApiService
import com.example.randommammals.network.RandomFoxApiService
import com.example.randommammals.network.TheCatApiService
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.Duck
import com.example.randommammals.network.responses.Fox
import com.example.randommammals.util.Resource

class RandomMammalsRepositoryImpl(
    val duckDataSource : RandomDuckApiService,
    val foxDataSource: RandomFoxApiService,
    val catDataSource: TheCatApiService,
): RandomMammalsRepository {
    override suspend fun getRandomDuck(): Resource<Duck> {
        val result = try {
            duckDataSource.getRandomDuck()
        } catch (e: Exception){
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }

    override suspend fun getRandomCat(): Resource<Cat> {
        val result = try {
            catDataSource.getRandomCat()
        } catch (e: Exception){
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }

    override suspend fun getRandomFox(): Resource<Fox> {
        val result = try {
            foxDataSource.getRandomFox()
        } catch (e: Exception){
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }
}