package com.example.weatherapi.model

data class AllItemsForecastFiveDays(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastFiveDays>,
    val message: Int
)