package com.example.eatme.api

import com.example.eatme.model.RequestRestaurants
import com.example.eatme.model.Restaurant
import retrofit2.http.GET

interface Api {

    @GET("restaurants")
    //suspend fun getRestaurant(): Restaurant
    suspend fun getRestaurants(): RequestRestaurants
}