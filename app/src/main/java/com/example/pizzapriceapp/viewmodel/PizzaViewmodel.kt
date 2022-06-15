package com.example.pizzapriceapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzapriceapp.rest.PizzaRepo
import com.example.pizzapriceapp.rest.PizzaRepoImpl
import com.example.pizzapriceapp.utils.PizzaTime
import kotlinx.coroutines.*

class PizzaViewModel(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val coroutineScope: CoroutineScope = CoroutineScope(SupervisorJob() + ioDispatcher),
    private val pizzaRepo: PizzaRepo = PizzaRepoImpl()
) : ViewModel() {
    val pies: LiveData<PizzaTime> get() = _pieData
    private val _pieData: MutableLiveData<PizzaTime> = MutableLiveData(PizzaTime.LOADING)

    fun getAllPizzas() {
        coroutineScope.launch {
            pizzaRepo.makePizza().collect {
                _pieData.postValue(it)
            }
        }
    }
}