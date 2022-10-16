package com.example.pizzeriaapp.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState.Loading.endOfPaginationReached
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.pizzeriaapp.data.extensions.toProductEntity
import com.example.pizzeriaapp.data.models.room.ProductEntity
import com.example.pizzeriaapp.data.retrofit.PizzaAllapalaApiService
import com.example.pizzeriaapp.data.room.PizzasDatabase
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class Mediator(
    private val db: PizzasDatabase,
    private val pizzaService: PizzaAllapalaApiService
) : RemoteMediator<Int, ProductEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ProductEntity>
    ): MediatorResult {
        return try {
            // Текущая тестовая API не поддерживает постраничный вывод
            when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND, LoadType.APPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
            }
            val result = pizzaService.getProducts()
            if (!result.ok) return MediatorResult.Error(Throwable("Server return status error"))
            db.withTransaction {
                val productEntityList = result.products.map { it.toProductEntity() }
                db.getProductsDao().run {
                    deleteAll()
                    insert(productEntityList)
                }
            }
            MediatorResult.Success(false)
        } catch (ex: IOException) {
            MediatorResult.Error(ex)
        } catch (ex: HttpException) {
            MediatorResult.Error(ex)
        }
    }
}