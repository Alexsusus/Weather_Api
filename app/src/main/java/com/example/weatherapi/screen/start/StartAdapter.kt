package com.example.weatherapi.screen.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi.R
import com.example.weatherapi.model.ForecastFiveDays
import com.example.weatherapi.model.OLDForecastFiveDays
import kotlinx.android.synthetic.main.fragment_start.view.*
import kotlinx.android.synthetic.main.item_weather_layout.view.*

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>() {


    //var listStart = emptyList<WeatherClass>()
    var listStart = emptyList<OLDForecastFiveDays>()//emptyList<OLDForecastFiveDays>()
    var text1 = "1"
    var text2 = "2"
    var text3 = "3"
    var listTest = emptyList<ForecastFiveDays>()

    class StartViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_weather_layout,
            parent, false
        )
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {

        if (listStart.isNotEmpty()) {
            holder.itemView.description.text =
                listStart.get(0).list[position].weather[0].description
            holder.itemView.temp.text =
                listStart[0].list[position].main.temp.toInt().toString().plus("°C")
            holder.itemView.date.text = listStart[0].list[position].dt_txt
        }


    }

    override fun getItemCount(): Int {
        return 5 //listStart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    //fun setList(list: WeatherClass){
    fun setList(list: OLDForecastFiveDays) {
        listStart = listOf(list)
        notifyDataSetChanged()
    }
}