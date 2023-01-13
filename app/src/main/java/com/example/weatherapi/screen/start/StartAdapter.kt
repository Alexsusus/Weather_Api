package com.example.weatherapi.screen.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi.R
import com.example.weatherapi.model.items.AllItems
import kotlinx.android.synthetic.main.item_weather_layout.view.*

class StartAdapter:RecyclerView.Adapter<StartAdapter.StartViewHolder>() {

    var listStart = emptyList<AllItems>()

    class StartViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_layout,
            parent, false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.description.text = listStart[position].main.description
        holder.itemView.temp.text = listStart[position].main.temp.toString()
        holder.itemView.feels_like.text = listStart[position].main.feels_like.toString()
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AllItems>){
        listStart = list
        notifyDataSetChanged()
    }
}