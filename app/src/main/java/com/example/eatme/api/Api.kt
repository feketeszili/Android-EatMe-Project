package com.example.eatme.api

import com.example.eatme.model.RequestRestaurants
import retrofit2.http.Query
import retrofit2.http.GET


interface Api {

    @GET("restaurants")
    suspend fun getRestaurants(  @Query("name") name:String? = null,
                                 @Query("country") country:String? = "US"):RequestRestaurants
}