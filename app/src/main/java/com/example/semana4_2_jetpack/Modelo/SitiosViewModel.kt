package com.example.semana4_2_jetpack.Modelo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semana4_2_jetpack.Beans.Sitios
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SitiosViewModel:ViewModel() {

    var listaSitios:ArrayList<Sitios> by mutableStateOf(arrayListOf())

    fun getSitios(){
        viewModelScope.launch() {  }
        viewModelScope.launch(Dispatchers.IO) {
            val response=RetrofitClient.placeHolder.getSitios()
            withContext(Dispatchers.Main){
                if(response.body()!=null){
                    listaSitios=response.body() as ArrayList<Sitios>
                }
            }
        }
    }

}