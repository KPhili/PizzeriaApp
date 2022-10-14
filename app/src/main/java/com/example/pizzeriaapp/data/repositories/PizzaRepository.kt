package com.example.pizzeriaapp.data.repositories

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.example.pizzeriaapp.data.extensions.toProduct
import com.example.pizzeriaapp.data.paging.Mediator
import com.example.pizzeriaapp.data.room.PizzasDatabase
import com.example.pizzeriaapp.domain.repositories.IPizzaRepository
import kotlinx.coroutines.flow.map

class PizzaRepository(
    private val mediator: Mediator,
    private val db: PizzasDatabase
) : IPizzaRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getPizzas() = Pager(
        PagingConfig(pageSize = PAGE_SIZE),
        remoteMediator = mediator,
        pagingSourceFactory = { db.getProductsDao().get() })
        .flow.map {
            it.map { productEntity ->
                productEntity.toProduct()
            }
        }


    companion object {
        private const val PAGE_SIZE = 10
    }
}