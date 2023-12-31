package com.example.randommammals.di

import com.example.randommammals.data.RandomMammalsRepository
import com.example.randommammals.data.RandomMammalsRepositoryImpl
import com.example.randommammals.network.RandomDuckApiService
import com.example.randommammals.network.RandomFoxApiService
import com.example.randommammals.network.TheCatApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestModule {
    @Provides
    @Singleton
    fun provideRandomDuckApiService(): RandomDuckApiService {
        return FakeRandomDuckApi()
    }

    @Provides
    @Singleton
    fun provideRandomFoxApiService(): RandomFoxApiService {
        return FakeRandomFoxApi()
    }

    @Provides
    @Singleton
    fun provideTheCatApiService(): TheCatApiService {
        return FakeTheCatApi()
    }

    @Provides
    @Singleton
    fun provideRandomMammalsRepositoryImpl(
        duckApi: RandomDuckApiService,
        foxApi: RandomFoxApiService,
        theCatApi: TheCatApiService
    ): RandomMammalsRepository {
        return RandomMammalsRepositoryImpl(
            duckDataSource = duckApi,
            foxDataSource = foxApi,
            catDataSource = theCatApi
        )
    }
}