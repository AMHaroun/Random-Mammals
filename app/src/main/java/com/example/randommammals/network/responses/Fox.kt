package com.example.randommammals.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class Fox(
    val image: String,
    val link: String
)