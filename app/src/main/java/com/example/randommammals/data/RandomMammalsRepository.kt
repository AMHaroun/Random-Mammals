package com.example.randommammals.data

import com.example.randommammals.data.local.room.entity.Mammal
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.CatItem
import com.example.randommammals.network.responses.Duck
import com.example.randommammals.network.responses.Fox
import com.example.randommammals.util.Resource
import kotlinx.coroutines.flow.Flow

interface RandomMammalsRepository {

    suspend fun getRandomDuck(): Resource<Duck>

    suspend fun getRandomCat(): Resource<List<Cat>>

    suspend fun getRandomFox(): Resource<Fox>

    suspend fun saveMammal(url: String): Unit

    suspend fun deleteMammal(url: String): Unit

    fun getMammals(): Flow<List<Mammal>>
}