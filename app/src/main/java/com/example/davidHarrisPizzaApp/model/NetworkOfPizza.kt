package com.example.davidHarrisPizzaApp.model

import com.google.gson.annotations.SerializedName

data class NetworkOfPizza(
    @SerializedName("size")
    val size: String?
)
