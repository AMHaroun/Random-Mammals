package com.example.randommammals.data

import com.example.randommammals.network.RandomDuckApiService
import com.example.randommammals.network.RandomFoxApiService
import com.example.randommammals.network.TheCatApiService
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.Duck
import com.example.randommammals.network.responses.Fox
import com.example.randommammals.util.Resource

class RandomMammalsRepositoryImpl(
    duckDataSource : RandomDuckApiService,
    foxDataSource: RandomFoxApiService,
    catDataSource: TheCatApiService,
): RandomMammalsRepository {
    override suspend fun getRandomDuck(): Resource<Duck> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomCat(): Resource<Cat> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomFox(): Resource<Fox> {
        TODO("Not yet implemented")
    }
}