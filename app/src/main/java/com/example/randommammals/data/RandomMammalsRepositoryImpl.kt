package com.example.randommammals.data

import android.util.Log
import com.example.randommammals.data.local.room.dao.MammalDao
import com.example.randommammals.network.RandomDuckApiService
import com.example.randommammals.network.RandomFoxApiService
import com.example.randommammals.network.TheCatApiService
import com.example.randommammals.network.responses.Cat
import com.example.randommammals.network.responses.Duck
import com.example.randommammals.network.responses.Fox
import com.example.randommammals.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RandomMammalsRepositoryImpl(
    val duckDataSource : RandomDuckApiService,
    val foxDataSource: RandomFoxApiService,
    val catDataSource: TheCatApiService,
    val mammalDao: MammalDao
): RandomMammalsRepository {
    override suspend fun getRandomDuck(): Resource<Duck> {
        val result = try {
            withContext(Dispatchers.IO){
                duckDataSource.getRandomDuck()
            }
        } catch (e: Exception){
            Log.d("DEBUG","${e.message} DUCK")
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }

    override suspend fun getRandomCat(): Resource<List<Cat>> {
        val result = try {
            withContext(Dispatchers.IO) {
                catDataSource.getRandomCat()
            }
        } catch (e: Exception){
            Log.d("DEBUG","${e.message} CAT")
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }

    override suspend fun getRandomFox(): Resource<Fox> {
        val result = try {
            withContext(Dispatchers.IO) {
                foxDataSource.getRandomFox()
            }
        } catch (e: Exception){
            Log.d("DEBUG","${e.message} FOX")
            return Resource.Error("A network error has occurred", null)
        }
        return Resource.Success(result)
    }
}