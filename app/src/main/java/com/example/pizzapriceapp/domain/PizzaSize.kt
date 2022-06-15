package com.example.pizzapriceapp.domain

enum class PriceOfPizza(val price: Int) {
    SMALL(4),
    MEDIUM(8),
    LARGE(15),
    NONE(0)
}