package com.aslansari.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: String,
    val name: String,
    val lastName: String,
    val email: String?
)
