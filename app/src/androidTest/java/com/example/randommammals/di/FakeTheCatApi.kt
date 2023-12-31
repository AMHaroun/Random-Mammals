package com.example.randommammals.di

import com.example.randommammals.network.TheCatApiService
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.CatItem
import java.io.IOException

class FakeTheCatApi: TheCatApiService {

    private var networkError = false
    override suspend fun getRandomCat(): Cat {
        if(networkError){
            throw IOException("Network error")
        }
        val catList = Cat()
        catList.addAll(
            listOf(
                CatItem(16,"23", "https://thisisafakeurl.com",86),
                CatItem(14,"22", "https://thisisafakeurl.com",56),
                CatItem(24,"8", "https://thisisafakeurl.com",46),
                CatItem(19,"4", "https://thisisafakeurl.com",36),
                CatItem(13,"15", "https://thisisafakeurl.com",20)
            )
        )
        return catList
    }

    fun toggleNetworkErrorException(){
        networkError = !networkError
    }
}