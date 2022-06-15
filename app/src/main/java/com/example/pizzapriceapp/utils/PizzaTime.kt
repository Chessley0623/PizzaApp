package com.example.pizzapriceapp.utils

import com.example.pizzapriceapp.domain.Order

sealed class PizzaTime{
    object LOADING : PizzaTime()
    data class SUCCESS(val orders: List<Order>) : PizzaTime()
    data class ERROR(val error: Exception) : PizzaTime()
}
