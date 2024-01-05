package com.example.randommammals.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.randommammals.entity.Mammal

@Dao
interface MammalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMammal(mammal: Mammal)

    @Delete
    suspend fun deleteMammal(mammal: Mammal)
}