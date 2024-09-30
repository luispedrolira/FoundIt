package com.luispedrolira.foundit.app.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LostAndFoundScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LostAndFoundScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Contenido inicial (principal)
        Column {
            // Texto superior
            Text(
                text = "¡Encuentra tus cosas perdidas!",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Nombre FoundIt
            Text(
                text = "FoundIt",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Barra de búsqueda
            SearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            // Título para categorías
            Text(
                text = "Categorías Populares",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Categorías populares (Se ponen cajas grises mientras...)
            PopularCategories()

            Spacer(modifier = Modifier.height(16.dp))

            // Objetos perdidos
            Text(
                text = "Objetos perdidos",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Lista de objetos perdidos
            LostItemsList()
        }

        // Barra de navegación inferior
        BottomNavigationBar()
    }
}

//Boton de navegación para todas las pantallas
@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Boton de Home (parte inferior)
        Box(
            modifier = Modifier
                .background(Color(0xFF4DB6AC), CircleShape) // Color turquesa
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Home", color = Color.Black, fontSize = 14.sp)
            }
        }

        // Boton de busqueda (sin fondo)
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )

        // Boton de perfil (sin fondo)
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun SearchBar() {
    var searchQuery by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        label = { Text("Buscar") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar",
                tint = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp)),
        keyboardOptions = KeyboardOptions.Default
    )
}

@Composable
fun PopularCategories() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        CategoryBox("Cargadores")
        CategoryBox("Mochilas")
    }
}

@Composable
fun CategoryBox(title: String) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .size(150.dp, 100.dp)
            .background(Color.Gray, RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun LostItemsList() {
    // Ejemplo de elementos de los objetos perdidos
    val items = listOf(
        "Mochila negra" to "Encontrado en biblioteca 10:30 am",
        "Audífonos Samsung" to "Encontrado en cafetería",
        "Teléfono plegable" to "Encontrado en sala de estudio"
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            LostItemBox(item.first, item.second)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LostItemBox(title: String, location: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Caja gris simulando un icono o imagen para mientras
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.Gray, RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )
            Text(
                text = location,
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Start
            )
        }
        Button(
            onClick = { /* Navegar a detalles del objeto perdido */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726))
        ) {
            Text(text = "MÁS DETALLES →", fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLostAndFoundScreen() {
    LostAndFoundScreen()
}

