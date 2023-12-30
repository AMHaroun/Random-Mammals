package com.example.randommammals.data

import com.example.randommammals.network.RandomDuckApiService
import com.example.randommammals.network.responses.Duck
import java.io.IOException

class FakeRandomDuckApi : RandomDuckApiService {

    private var networkError = false
    override suspend fun getRandomDuck(): Duck {
        if(networkError){
            throw IOException("Network Error")
        }
        return Duck("This is a duck object!", "https://thisisafakeurl.com")
    }

    fun throwNetworkErrorException(){
        networkError = true
    }
}