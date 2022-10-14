package com.example.pizzeriaapp.data.models.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val price: String?
)