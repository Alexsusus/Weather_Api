package com.example.weatherapi.model

data class WeatherClass(
    val cod: Int,
    val id: Int,
    val main: MainX,
    val name: String,
    val timezone: Int,
    val weather: List<Weather>
)