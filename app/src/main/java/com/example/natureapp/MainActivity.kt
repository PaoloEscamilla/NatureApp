package com.example.natureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.GlideImage
import com.example.natureapp.ui.theme.NatureAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val placesList = listOf(
                        NaturalPlace("Parque Nacional Yellowstone", "Famoso por sus géiseres y fauna", "https://example.com/yellowstone.jpg"),
                        NaturalPlace("Montañas Rocosas", "Paisajes montañosos impresionantes", "https://example.com/rockymountains.jpg"),
                        NaturalPlace("Gran Cañón", "Uno de los cañones más grandes del mundo", "https://example.com/grandcanyon.jpg"),
                        NaturalPlace("Cascadas del Niágara", "Famosas cataratas", "https://example.com/niagara.jpg"),
                        NaturalPlace("Torres del Paine", "Paisajes deslumbrantes", "https://example.com/torresdelpaine.jpg")
                    )
                    PlacesList(places = placesList)
                }
            }
        }
    }
}

data class NaturalPlace(
    val name: String,
    val description: String,
    val imageUrl: String
)

@Composable
fun PlaceCard(place: NaturalPlace) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column {
            GlideImage(
                model = place.imageUrl,
                contentDescription = place.name,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = place.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = place.description,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun PlacesList(places: List<NaturalPlace>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(places) { place ->
            PlaceCard(place = place)
        }
    }
}
