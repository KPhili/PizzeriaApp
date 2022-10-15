package com.example.pizzeriaapp.di

import androidx.room.Room
import com.example.pizzeriaapp.data.paging.Mediator
import com.example.pizzeriaapp.data.repositories.PizzaRepository
import com.example.pizzeriaapp.data.retrofit.HttpInterceptor
import com.example.pizzeriaapp.data.retrofit.PizzaAllapalaApiService
import com.example.pizzeriaapp.data.room.PizzasDatabase
import com.example.pizzeriaapp.domain.repositories.IPizzaRepository
import com.example.pizzeriaapp.presentation.adapters.ProductsAdapter
import com.example.pizzeriaapp.presentation.utils.IImageLoader
import com.example.pizzeriaapp.presentation.utils.GlideImageLoader
import com.example.pizzeriaapp.presentation.viewmodels.MainViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // viewmodels
    viewModel { MainViewModel(get()) }

    factory { ProductsAdapter.ProductComparator() }
    // adapters
    factoryOf(::ProductsAdapter)

    // repositories
    singleOf(::PizzaRepository) bind IPizzaRepository::class

    // retrofit
    val API_URL = "apiUrl"

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named(API_URL)))
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(get()).build())
            .build()
    }

    factoryOf(::HttpInterceptor) bind Interceptor::class

    single {
        get<Retrofit>().create(PizzaAllapalaApiService::class.java)
    }

    single(named(API_URL)) { "https://pizzaallapala.p.rapidapi.com/" }

    // room
    val DB_NAME = "dbName"
    single(named(DB_NAME)) { "Pizzas.db" }
    single {
        Room
            .databaseBuilder(get(), PizzasDatabase::class.java, get(named(DB_NAME)))
            .build()
    }

    // paging mediator
    factoryOf(::Mediator)

    // image loader
    factoryOf(::GlideImageLoader) bind IImageLoader::class
}