package com.example.weatherapi.data.api

import com.example.weatherapi.model.ForecastFiveDays
import com.example.weatherapi.model.OLDForecastFiveDays
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

   // @GET("weather?q=Kiev&appid=a2e01fc0156c6b14f833c14dc85e2a1e&units=metric&lang=ru") //one day
    @GET("forecast?lat=44.34&lon=10.99&appid=a2e01fc0156c6b14f833c14dc85e2a1e")

    //suspend fun getWeather():Response<WeatherClass>
    suspend fun getWeather():Response<OLDForecastFiveDays>
}