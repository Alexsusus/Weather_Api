package com.example.weatherapi.screen.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapi.data.repository.Repository
import com.example.weatherapi.model.AllItemsForecastFiveDays
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel : ViewModel() {

    var repos = Repository()

    //val myWeatherList: MutableLiveData<Response<WeatherClass>> = MutableLiveData()
    val myWeatherList: MutableLiveData<Response<AllItemsForecastFiveDays>> = MutableLiveData()


    fun getWeather(location:String){
        viewModelScope.launch {
           myWeatherList.value = repos.getWeatRep(location)
        }
    }

}