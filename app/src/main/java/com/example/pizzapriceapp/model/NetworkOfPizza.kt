package com.example.pizzapriceapp.model

import com.google.gson.annotations.SerializedName

data class NetworkOfPizza(
    @SerializedName("size")
    val size: String?
)
