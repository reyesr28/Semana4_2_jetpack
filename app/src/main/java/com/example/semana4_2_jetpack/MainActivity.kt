package com.example.semana4_2_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.semana4_2_jetpack.Beans.Sitios
import com.example.semana4_2_jetpack.Modelo.SitiosViewModel
import com.example.semana4_2_jetpack.ui.theme.Semana4_2_jetpackTheme

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<SitiosViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana4_2_jetpackTheme {

                Box(modifier = Modifier.fillMaxSize()){
                    viewModel.getSitios()
                    Vista(viewModel.listaSitios, viewModel)
                }

            }
        }
    }
}

@Composable
fun Vista(listaSitios: ArrayList<Sitios>,viewModel: SitiosViewModel) {

    Column(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .padding(15.dp)) {

        LazyColumn (contentPadding = PaddingValues(
            horizontal = 15.dp,
            vertical = 5.dp
        )){
            items(listaSitios){
                sitio->(
                        Card(modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(8.dp)) {
                            Column {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(sitio.imagen)
                                        .build(),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(height = 200.dp))
                                Text(text = "SitioID: ${sitio.idSitio}")
                                Text(text = "Descripción: ${sitio.descripcion}")

                            }
                        }
                        )
            }
        }

    }

}

















