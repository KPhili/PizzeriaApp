package com.example.pizzeriaapp.data.retrofit

import com.example.pizzeriaapp.data.models.api.PizzaApiResult
import retrofit2.http.GET

interface PizzaAllapalaApiService {
    @GET("productos")
    suspend fun getProducts(): PizzaApiResult
}