package com.example.pizzeriaapp.data.models.api

import com.google.gson.annotations.SerializedName

data class ProductAllapala(
    val id: Int,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("descripcion")
    val description: String,
    @SerializedName("linkImagen")
    val imageUrl: String,
    @SerializedName("precio")
    val price: String
)