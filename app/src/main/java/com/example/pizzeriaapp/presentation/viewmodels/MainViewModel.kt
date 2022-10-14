package com.example.pizzeriaapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pizzeriaapp.domain.models.Product
import com.example.pizzeriaapp.domain.repositories.IPizzaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val repository: IPizzaRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val product get() = _products.asStateFlow()

    init {

    }
}