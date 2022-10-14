package com.example.pizzeriaapp.data.extensions

import com.example.pizzeriaapp.data.models.api.ProductAllapala
import com.example.pizzeriaapp.data.models.room.ProductEntity
import com.example.pizzeriaapp.domain.models.Product

internal fun ProductAllapala.toProductEntity() =
    ProductEntity(id.toLong(), name, description, imageUrl, price)

internal fun ProductEntity.toProduct() = Product(id, name, description, imageUrl, price)