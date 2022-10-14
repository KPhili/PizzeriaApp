package com.example.pizzeriaapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pizzeriaapp.domain.models.Product
import com.example.pizzeriaapp.domain.repositories.IPizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.KoinApplication.Companion.init

class MainViewModel(
    private val repository: IPizzaRepository
) : ViewModel() {
    val product = repository.getPizzas().flowOn(Dispatchers.IO)
}