package com.example.davidHarrisPizzaApp.model

import com.google.gson.annotations.SerializedName

data class PizzaOrders(
    @SerializedName("order")
    val networkOfPizza: List<NetworkOfPizza>?
)
