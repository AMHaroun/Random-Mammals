package com.example.randommammals.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.randommammals.entity.Mammal
import kotlinx.coroutines.flow.Flow

@Dao
interface MammalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMammal(mammal: Mammal)

    @Delete
    suspend fun deleteMammal(mammal: Mammal)

    @Query("SELECT * FROM mammal")
    fun getMammals(): Flow<List<Mammal>>
}