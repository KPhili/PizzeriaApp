package com.example.pizzeriaapp.domain.models

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val price: String
)
