package com.example.weatherapi.model.items

data class AllItems(
    val main: Main,
    val weather: List<Weather>
)