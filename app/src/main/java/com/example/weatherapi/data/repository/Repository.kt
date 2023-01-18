package com.example.weatherapi.data.repository

import com.example.weatherapi.data.api.RetrofitInstance
import com.example.weatherapi.model.OLDForecastFiveDays
import retrofit2.Response

class Repository {

    private val key = "a2e01fc0156c6b14f833c14dc85e2a1e"

    private val mertic = "metric"

    private val language = "ru"

    suspend fun getWeatRep(location: String): Response<OLDForecastFiveDays> {
        return RetrofitInstance.api.getWeather(location, key, mertic, language)
    }
}
