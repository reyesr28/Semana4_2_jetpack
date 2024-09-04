package com.example.semana4_2_jetpack.Interface

import com.example.semana4_2_jetpack.Beans.Sitios
import retrofit2.Response
import retrofit2.http.GET

interface PlaceHolder {

    @GET("sitios.php")
    suspend fun getSitios():Response<List<Sitios>>

}