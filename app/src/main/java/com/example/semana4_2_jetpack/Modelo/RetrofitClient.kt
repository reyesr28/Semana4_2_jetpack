package com.example.semana4_2_jetpack.Modelo

import com.example.semana4_2_jetpack.Interface.PlaceHolder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    val placeHolder:PlaceHolder by lazy {
        Retrofit.Builder()
            .baseUrl("https://dev.formandocodigo.com/ServicioTour/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlaceHolder::class.java)
    }

}