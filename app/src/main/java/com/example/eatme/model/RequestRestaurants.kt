package com.example.eatme.model

data class RequestRestaurants(
    val page: Int,
    val per_page: Int,
    val restaurants: List<Restaurant>,
    val total_entries: Int
)