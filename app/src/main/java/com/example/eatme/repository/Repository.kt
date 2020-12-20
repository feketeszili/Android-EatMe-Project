package com.example.eatme.repository

import com.example.eatme.api.RetrofitInstance
import com.example.eatme.model.RequestRestaurants
import com.example.eatme.model.Restaurant

class Repository{

    suspend fun getRestaurants(): RequestRestaurants {
        //return RetrofitInstance.api.getRestaurant()
        return RetrofitInstance.api.getRestaurants()
    }
}