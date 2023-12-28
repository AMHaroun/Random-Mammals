package com.example.randommammals.network

import com.example.randommammals.network.responses.Fox
import retrofit2.http.GET

interface RandomFoxApiService {
    @GET("floof")
    suspend fun getRandomFox(): Fox
}