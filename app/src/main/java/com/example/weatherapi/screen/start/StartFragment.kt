package com.example.weatherapi.screen.start

import android.location.Location
import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi.R
import kotlinx.android.synthetic.main.fragment_start.*
import kotlinx.android.synthetic.main.fragment_start.view.*



class StartFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StartAdapter
    private var newCity = "london"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_start, container, false)
        recyclerView = view.rv_start
        adapter = StartAdapter()
        recyclerView.adapter = adapter



        view.setCity.setOnClickListener {
            if (view?.editCity?.text.toString() != ""){
                newCity = view?.editCity?.text.toString()
                Toast.makeText(context,newCity,Toast.LENGTH_SHORT).show()
                showCity()
            }
        }

        showCity()
        return view
    }
    private fun showCity(){
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.getWeather(newCity)
        viewModel.myWeatherList.observe(viewLifecycleOwner) { list ->
            list.body()?.let {
                adapter.setList(it)
                view?.city_name?.text = it.city.name
            }
        }
    }
}
