package com.example.randommammals.network

import com.example.randommammals.network.responses.Duck
import retrofit2.http.GET

interface RandomDuckApiService {

    @GET("random")
    suspend fun getRandomDuck(): Duck
}