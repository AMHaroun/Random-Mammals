package com.example.randommammals.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class CatItem(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)