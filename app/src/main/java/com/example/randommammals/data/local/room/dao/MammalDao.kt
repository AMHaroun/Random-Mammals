package com.example.randommammals.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.randommammals.data.local.room.entity.Mammal
import kotlinx.coroutines.flow.Flow

@Dao
interface MammalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMammal(mammal: Mammal)

    @Delete
    suspend fun deleteMammal(mammal: Mammal)

    @Query("SELECT * FROM mammal")
    fun getMammals(): Flow<List<Mammal>>

    @Query("SELECT * FROM Mammal WHERE url = :desiredUrl")
    suspend fun getMammalByUrl(desiredUrl: String): Mammal?

}