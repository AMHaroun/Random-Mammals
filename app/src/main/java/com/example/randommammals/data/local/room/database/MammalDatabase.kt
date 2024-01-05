package com.example.randommammals.data.local.room.database

import androidx.room.Database
import com.example.randommammals.data.local.room.dao.MammalDao
import com.example.randommammals.data.local.room.entity.Mammal

@Database(
    entities = [Mammal::class],
    version = 1
)
abstract class MammalDatabase {

    abstract val dao: MammalDao
}