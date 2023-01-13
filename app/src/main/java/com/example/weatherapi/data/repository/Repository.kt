package com.example.weatherapi.data.repository

import com.example.weatherapi.data.api.RetrofitInstance
import com.example.weatherapi.model.items.AllItems
import retrofit2.Response

class Repository {
    suspend fun getWeatRep(): Response<AllItems>{
        return RetrofitInstance.api.getWeather()
    }
}