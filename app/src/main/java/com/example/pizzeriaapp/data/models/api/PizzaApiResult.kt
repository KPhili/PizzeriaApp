package com.example.pizzeriaapp.data.models.api

import com.google.gson.annotations.SerializedName

data class PizzaApiResult(
    val ok: Boolean,
    @SerializedName("productos")
    val products: List<ProductAllapala>
)