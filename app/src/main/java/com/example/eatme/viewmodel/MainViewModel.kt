package com.example.eatme.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatme.model.RequestRestaurants
import com.example.eatme.model.Restaurant
import com.example.eatme.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<RequestRestaurants> = MutableLiveData()

    fun getRestaurants(){
        viewModelScope.launch{
            val response: RequestRestaurants = repository.getRestaurants()
            myResponse.value = response
        }
    }
}