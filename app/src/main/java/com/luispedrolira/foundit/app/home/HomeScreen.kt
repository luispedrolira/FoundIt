package com.luispedrolira.foundit.app.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoundItScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoundItScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título y subtítulo
        Text(
            text = "FoundIt",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "¡Encuentra tus cosas perdidas!",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Barra de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        // Sección de Categorías Populares
        Text(
            text = "Categorías Populares",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(3) { // Número de categorías
                CategoryCard("Cargadores", R.drawable.ic_charger) // Imagen ficticia
            }
        }

        // Sección de Objetos Perdidos
        Text(
            text = "Objetos perdidos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(3) { // Número de objetos perdidos
                LostItemCard(
                    title = "Mochila negra",
                    location = "Encontrado en biblioteca 10:30 am",
                    imageRes = R.drawable.ic_backpack // Imagen ficticia
                )
            }
        }

        // Barra de Navegación Inferior
        BottomNavigationBar()
    }
}

@Composable
fun CategoryCard(categoryName: String, imageRes: Int) {
    Column(
        modifier = Modifier
            .size(120.dp)
            .clickable { /* Navegar a detalles de categoría */ },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = categoryName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray, RoundedCornerShape(10.dp))
        )
        Text(
            text = categoryName,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun LostItemCard(title: String, location: String, imageRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .background(Color.LightGray, RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = location, fontSize = 12.sp, color = Color.Gray)
        }
        Button(
            onClick = { /* Navegar a detalles del objeto perdido */ },
            colors = ButtonDefaults.buttonColors(Color(0xFFFFA726))
        ) {
            Text(text = "MÁS DETALLES →", fontSize = 12.sp)
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFFF5F5F5),
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            selected = true, // Seleccionado por defecto
            onClick = { /* Acción de home */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home), // Imagen ficticia
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Acción para otra sección */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile), // Imagen ficticia
                    contentDescription = "Profile"
                )
            },
            label = { Text("Profile") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFoundItScreen() {
    FoundItScreen()
}


