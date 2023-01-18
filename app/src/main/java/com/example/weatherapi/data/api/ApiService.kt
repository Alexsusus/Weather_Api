package com.example.weatherapi.data.api


import com.example.weatherapi.model.OLDForecastFiveDays
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("forecast")
    suspend fun getWeather(
        @Query("q") location:String,
        @Query("appid") key:String,
        @Query("units") metr: String,
        @Query("lang") lang: String
    ):Response<OLDForecastFiveDays>

}













