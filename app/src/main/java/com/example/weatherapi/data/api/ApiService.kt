package com.example.weatherapi.data.api

import com.example.weatherapi.model.WeatherClass
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather?q=Kiev&appid=a2e01fc0156c6b14f833c14dc85e2a1e&units=metric&lang=ru")
    suspend fun getWeather():Response<WeatherClass>
}