package com.example.eatme.repository

import com.example.eatme.api.RetrofitInstance
import com.example.eatme.model.RequestRestaurants
import com.example.eatme.model.Restaurant
import retrofit2.Response

class Repository{
// changed to Response it was simple RequestRestaurants,
// it also changed in API to Response<>
    /*suspend fun getRestaurants(): Response<RequestRestaurants> {
        //return RetrofitInstance.api.getRestaurant()
        return RetrofitInstance.api.getRestaurants()
    }*/

    suspend fun getRestaurants(): RequestRestaurants{
        return RetrofitInstance.api.getRestaurants()
    }
}