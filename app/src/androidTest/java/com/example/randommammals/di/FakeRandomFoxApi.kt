package com.example.randommammals.di

import com.example.randommammals.network.RandomFoxApiService
import com.example.randommammals.network.responses.Fox
import java.io.IOException

class FakeRandomFoxApi : RandomFoxApiService{

    private var networkError = false
    override suspend fun getRandomFox(): Fox {
        if(networkError){
            throw IOException("Network Error")
        }
        return Fox("https://thisisafakeurl.com", "https://thisisafakeurl.com")
    }

    fun throwNetworkErrorException(){
        networkError = true
    }
}