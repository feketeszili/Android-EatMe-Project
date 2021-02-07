package com.example.eatme.api

import com.example.eatme.model.RequestRestaurants
import com.example.eatme.model.Restaurant
import retrofit2.http.Query
import retrofit2.http.GET
import retrofit2.Response

interface Api {

    @GET("restaurants")
    //suspend fun getRestaurant(): Restaurant
    suspend fun getRestaurants(): RequestRestaurants

// try with query
    /*suspend fun getRestaurants(  @Query("name") name:String? = null,
                                 @Query("country") country:String? = "US"):RequestRestaurants*/
}