package com.example.randommammals.di

import android.content.Context
import androidx.room.Room
import com.example.randommammals.data.RandomMammalsRepository
import com.example.randommammals.data.RandomMammalsRepositoryImpl
import com.example.randommammals.data.local.room.dao.MammalDao
import com.example.randommammals.data.local.room.database.MammalDatabase
import com.example.randommammals.network.RandomDuckApiService
import com.example.randommammals.network.RandomFoxApiService
import com.example.randommammals.network.TheCatApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideFakeRandomMammalsRepository(): FakeRandomMammalsRepository {
        return FakeRandomMammalsRepository()
    }

    @Provides
    @Singleton
    fun provdeMammalDatabase(@ApplicationContext appContext: Context): MammalDatabase {
        return Room.databaseBuilder(
            appContext,
            MammalDatabase::class.java,
            "MammalDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMammalDao(mammalDatabase: MammalDatabase): MammalDao{
        return mammalDatabase.dao
    }

    @Provides
    @Singleton
    fun provideRandomMammalsRepositoryImpl(
        duckApi: RandomDuckApiService,
        foxApi: RandomFoxApiService,
        theCatApi: TheCatApiService,
        mammalDao: MammalDao
    ): RandomMammalsRepository {
        return RandomMammalsRepositoryImpl(
            duckApi,
            foxApi,
            theCatApi,
            mammalDao
        )
    }
}