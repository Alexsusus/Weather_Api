package com.example.weatherapi.screen.start

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.android.synthetic.main.fragment_start.view.*


class StartFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StartAdapter
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_start, container, false)
        recyclerView = view.rv_start
        adapter = StartAdapter()
        recyclerView.adapter = adapter

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        view.location.setOnClickListener {
            findLocation()
        }

        view.setCity.setOnClickListener {
            if (view?.editCity?.text.toString() != "") {
                val clientCity = view?.editCity?.text.toString()
                showCity(clientCity)
                closeKeyboard()
                view?.editCity?.text = null
            }
        }

        findLocation()
        return view
    }

    private fun findLocation() {

        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            }
            != PackageManager.PERMISSION_GRANTED && context?.let {
                ActivityCompat.checkSelfPermission(it, Manifest.permission.ACCESS_COARSE_LOCATION)
            } != PackageManager.PERMISSION_GRANTED
        ) {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 101
                )
            }
            return
        }

        val ct = CancellationTokenSource()
        fusedLocationClient
            .getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, ct.token)
            .addOnCompleteListener {
                getNameCityFromCord(it.result.latitude, it.result.longitude)
            }
    }

    private fun getNameCityFromCord(lat: Double, lng: Double){
        val geocoder = context?.let { Geocoder(it) }

        if (Build.VERSION.SDK_INT >= 33) {
            geocoder?.getFromLocation(lat, lng, 1, object : Geocoder.GeocodeListener {
                override fun onGeocode(addresses: MutableList<Address>) {
                    showCity(addresses[0].locality)
                }
                override fun onError(errorMessage: String?) {
                    Toast.makeText(context, "Ошибка геолокации", Toast.LENGTH_SHORT).show()
                    super.onError(errorMessage)
                }
            })
        }
        else {
            showCity(geocoder?.getFromLocation(lat, lng, 1)?.get(0)?.locality.toString())
        }
    }


    private fun showCity(city: String) {
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.getWeather(city)
        viewModel.myWeatherList.observe(viewLifecycleOwner) { list ->
            list.body()?.let {
                adapter.setList(it)
                view?.city_name?.text = it.city.name
            }
        }
    }

    private fun closeKeyboard() {
        val inputManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            requireView().windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

}


