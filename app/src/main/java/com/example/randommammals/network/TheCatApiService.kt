package com.example.randommammals.network

import com.example.randommammals.network.responses.Cat
import com.example.randommammals.util.ApiKeys
import retrofit2.http.GET
import retrofit2.http.Headers

interface TheCatApiService {

    @Headers("x-api-key: ${ApiKeys.theCatApiKey}")
    @GET("images/search")
    suspend fun getRandomCat(): Cat

}