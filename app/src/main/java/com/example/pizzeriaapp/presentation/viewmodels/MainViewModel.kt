package com.example.pizzeriaapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pizzeriaapp.domain.repositories.IPizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class MainViewModel(
    private val repository: IPizzaRepository
) : ViewModel() {
    val product = repository.getPizzas().flowOn(Dispatchers.IO)
}