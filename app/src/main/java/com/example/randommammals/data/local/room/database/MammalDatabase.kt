package com.example.randommammals.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.randommammals.data.local.room.dao.MammalDao
import com.example.randommammals.data.local.room.entity.Mammal

@Database(
    entities = [Mammal::class],
    version = 1
)
abstract class MammalDatabase: RoomDatabase() {

    abstract val dao: MammalDao
}