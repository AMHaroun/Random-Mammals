package com.example.randommammals.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mammal(
    val url: String,
    @PrimaryKey
    val id: Int = 0
)

