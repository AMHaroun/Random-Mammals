package com.example.randommammals.di

import com.example.randommammals.data.RandomMammalsRepository
import com.example.randommammals.data.RandomMammalsRepositoryImpl
import com.example.randommammals.network.RandomDuckApiService
import com.example.randommammals.network.RandomFoxApiService
import com.example.randommammals.network.TheCatApiService
import com.example.randommammals.util.Constants
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRandomDuckApiService(): RandomDuckApiService{
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(Constants.RANDOMDUCK_URL)
            .build()
            .create(RandomDuckApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRandomFoxApiService(): RandomFoxApiService{
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(Constants.RANDOMFOX_URL)
            .build()
            .create(RandomFoxApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTheCatApiService(): TheCatApiService{
        return Retrofit.Builder()
            .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory("application/json".toMediaType()))
            .baseUrl(Constants.THECATAPI_URL)
            .build()
            .create(TheCatApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRandomMammalsRepositoryImpl(
        duckApi: RandomDuckApiService,
        foxApi: RandomFoxApiService,
        theCatApi: TheCatApiService
    ): RandomMammalsRepository{
       return RandomMammalsRepositoryImpl(
           duckDataSource = duckApi,
           foxDataSource = foxApi,
           catDataSource = theCatApi
       )
    }

}