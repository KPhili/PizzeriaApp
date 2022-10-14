package com.example.pizzeriaapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pizzeriaapp.data.models.room.ProductEntity
import com.example.pizzeriaapp.data.room.dao.ProductsDao

@Database(entities = [ProductEntity::class], version = 1)
abstract class PizzasDatabase : RoomDatabase() {
    abstract fun getProductsDao(): ProductsDao
}