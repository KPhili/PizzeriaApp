package com.example.pizzeriaapp.data.room.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.pizzeriaapp.data.models.room.ProductEntity

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: ProductEntity)

    @Query("SELECT * FROM products")
    fun get(): PagingSource<Int, ProductEntity>

    @Query("DELETE FROM products")
    suspend fun deleteAll()

    @Insert
    fun insert(product: List<ProductEntity>)
}