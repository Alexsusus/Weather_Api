package com.example.weatherapi.data.repository

import com.example.weatherapi.data.api.RetrofitInstance
import com.example.weatherapi.model.ForecastFiveDays
import com.example.weatherapi.model.OLDForecastFiveDays
import retrofit2.Response

class Repository {
    suspend fun getWeatRep(): Response<OLDForecastFiveDays> {
        return RetrofitInstance.api.getWeather()
    }
}