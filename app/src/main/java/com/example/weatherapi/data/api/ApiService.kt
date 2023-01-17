package com.example.weatherapi.data.api

import com.example.weatherapi.data.repository.Repository
import com.example.weatherapi.model.ForecastFiveDays
import com.example.weatherapi.model.OLDForecastFiveDays
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

const val key: String = "a2e01fc0156c6b14f833c14dc85e2a1e"

interface ApiService {


    // @GET("weather?q=Kiev&appid=a2e01fc0156c6b14f833c14dc85e2a1e&units=metric&lang=ru") //one day

 //suspend fun getWeather():Response<WeatherClass>



    //@GET("forecast?q=rome&appid=$key&units=metric&lang=ru")

    //@GET("forecast?q=$st&appid=a2e01fc0156c6b14f833c14dc85e2a1e&units=metric&lang=ru")
    @GET("forecast")
    suspend fun getWeather(
        @Query("q") location:String,
        @Query("appid") key:String,
        @Query("units") metr: String,
        @Query("lang") lang: String
    ):Response<OLDForecastFiveDays>

}













