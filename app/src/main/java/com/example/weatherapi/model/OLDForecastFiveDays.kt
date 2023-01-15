package com.example.weatherapi.model

data class OLDForecastFiveDays(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastFiveDays>,
    val message: Int
)