package com.example.weatherapi.screen.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi.R
import com.example.weatherapi.model.AllItemsForecastFiveDays
import kotlinx.android.synthetic.main.fragment_start.view.*
import kotlinx.android.synthetic.main.item_weather_layout.view.*

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>() {


    var listResult = emptyList<AllItemsForecastFiveDays>()


    class StartViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_weather_layout,
            parent, false
        )
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {

        if (listResult.isNotEmpty()) {
            holder.itemView.description.text =
                listResult[0].list[position].weather[0].description
            holder.itemView.temp.text =
                listResult[0].list[position].main.temp.toInt().toString().plus("°C")
            holder.itemView.date.text = listResult[0].list[position].dt_txt
        }


    }

    override fun getItemCount(): Int {
        if (listResult.isNotEmpty())
            return listResult[0].list.lastIndex
        return 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: AllItemsForecastFiveDays) {
        listResult = listOf(list)
        notifyDataSetChanged()
    }
}