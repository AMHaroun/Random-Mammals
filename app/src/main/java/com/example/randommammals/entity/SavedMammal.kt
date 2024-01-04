package com.example.randommammals.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedMammal(
    @PrimaryKey
    val id: Int,
    val url: String
)

