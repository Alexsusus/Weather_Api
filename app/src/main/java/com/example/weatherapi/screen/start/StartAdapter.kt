package com.example.weatherapi.screen.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi.R
import com.example.weatherapi.model.ForecastFiveDays
import com.example.weatherapi.model.OLDForecastFiveDays
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

        /*holder.itemView.description.text = listStart[position].weather[0].description
        holder.itemView.temp.text = listStart[position].main.temp.toString()
        holder.itemView.feels_like.text = listStart[position].main.feels_like.toString()*/

        /* holder.itemView.description.text = listStart[0].list[0].weather[0].description
         holder.itemView.temp.text = listStart[0].list[0].main.temp.toString()
         holder.itemView.feels_like.text = listStart[0].list[0].main.feels_like.toString()*/



        /*if (listStart.isNotEmpty()) {
            holder.itemView.description.text = listStart.get(position).list[0].weather[0].description
            holder.itemView.temp.text = listStart.get(position).list[0].main.temp.toString()
            holder.itemView.date.text = listStart.get(position).list[0].dt_txt
        }*/


    }

    override fun getItemCount(): Int {
        return 5 //listStart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    //fun setList(list: WeatherClass){
    fun setList(list: OLDForecastFiveDays) {
        listStart = listOf(list)
        System.err.println(list.city.name)
        notifyDataSetChanged()
    }
}