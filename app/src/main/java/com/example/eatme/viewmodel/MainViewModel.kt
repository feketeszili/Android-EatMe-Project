package com.example.eatme.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatme.model.Restaurant
import com.example.eatme.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<List<Restaurant>> = MutableLiveData()

    fun getRestaurants(){
        viewModelScope.launch{
            val response = repository.getRestaurants().restaurants
            myResponse.postValue(response)
            Log.d("van adat", response.map{it.name}.toString())
        }
    }
}