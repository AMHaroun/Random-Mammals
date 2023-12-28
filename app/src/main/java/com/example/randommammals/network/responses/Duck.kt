package com.example.randommammals.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class Duck(
    val message: String,
    val url: String
)