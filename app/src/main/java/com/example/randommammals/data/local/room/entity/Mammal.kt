package com.example.randommammals.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mammal(
    val url: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

