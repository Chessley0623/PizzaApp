package com.example.davidHarrisPizzaApp.utils

import com.example.davidHarrisPizzaApp.domain.Order

sealed class PizzaTime{
    object LOADING : PizzaTime()
    data class SUCCESS(val orders: List<Order>) : PizzaTime()
    data class ERROR(val error: Exception) : PizzaTime()
}
