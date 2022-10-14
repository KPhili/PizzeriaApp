package com.example.pizzeriaapp.domain.repositories

import androidx.paging.PagingData
import com.example.pizzeriaapp.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface IPizzaRepository {
    fun getPizzas(): Flow<PagingData<Product>>
}