package com.example.pizzapriceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.pizzapriceapp.domain.Order
import com.example.pizzapriceapp.domain.PriceOfPizza
import com.example.pizzapriceapp.utils.PizzaTime
import com.example.pizzapriceapp.viewmodel.PizzaViewModel

private const val TAG = "PIZZA"
class MainActivity : AppCompatActivity() {

    private val pizzaViewModel by lazy {
        ViewModelProvider(this)[PizzaViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pizzaViewModel.pies.observe(this) {
            when (it) {
                is PizzaTime.LOADING -> {}
                is PizzaTime.SUCCESS -> {
                    calculateTotal(it.orders)
                }
                is PizzaTime.ERROR -> {}
            }
        }

        pizzaViewModel.getAllPizzas()

    }

    private fun calculateTotal(orders: List<Order>) {
        var total = 0
        for (pie in orders) {
            total += when (pie.size) {
                PriceOfPizza.SMALL -> pie.price
                PriceOfPizza.MEDIUM -> pie.price
                PriceOfPizza.LARGE -> pie.price
                else -> 0
            }
        }
        Log.d(TAG, "Your pizza order cost $total€") // this should total to 27
    }
}