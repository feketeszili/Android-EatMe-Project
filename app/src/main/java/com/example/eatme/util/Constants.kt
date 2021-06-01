package com.example.eatme.util

import com.example.eatme.model.Restaurant

class Constants {

    companion object{
        const val BASE_URL = "https://ratpark-api.imok.space/"
            //"http://opentable.herokuapp.com/"
            //"https://ratpark-api.imok.space/"
        //  http://86.120.35.107:1680/

        val favList: MutableList<Restaurant> = mutableListOf()
    }
}