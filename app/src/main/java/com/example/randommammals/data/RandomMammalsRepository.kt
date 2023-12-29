package com.example.randommammals.data

import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.Duck
import com.example.randommammals.network.responses.Fox
import com.example.randommammals.util.Resource

interface RandomMammalsRepository {

    suspend fun getRandomDuck(): Resource<Duck>

    suspend fun getRandomCat(): Resource<Cat>

    suspend fun getRandomFox(): Resource<Fox>
}