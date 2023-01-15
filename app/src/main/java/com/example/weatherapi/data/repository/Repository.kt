package com.example.weatherapi.data.repository

import com.example.weatherapi.data.api.RetrofitInstance
import com.example.weatherapi.model.WeatherClass
import retrofit2.Response

class Repository {
    suspend fun getWeatRep(): Response<WeatherClass> {
        return RetrofitInstance.api.getWeather()
    }
}