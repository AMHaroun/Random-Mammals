package com.example.randommammals.data

import com.example.randommammals.network.TheCatApiService
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.CatItem
import java.io.IOException

class FakeTheCatApi: TheCatApiService {

    private var networkError = false
    override suspend fun getRandomCat(): List<Cat> {
        if(networkError){
            throw IOException("Network error")
        }
        val catList = Cat()
        catList.addAll(
            listOf(
                CatItem(listOf(),16,"23", "https://thisisafakeurl.com",86),
                CatItem(listOf(),14,"22", "https://thisisafakeurl.com",56),
                CatItem(listOf(),24,"8", "https://thisisafakeurl.com",46),
                CatItem(listOf(),19,"4", "https://thisisafakeurl.com",36),
                CatItem(listOf(),13,"15", "https://thisisafakeurl.com",20)
            )
        )
        return listOf(catList)
    }

    fun throwNetworkErrorException(){
        networkError = true
    }
}