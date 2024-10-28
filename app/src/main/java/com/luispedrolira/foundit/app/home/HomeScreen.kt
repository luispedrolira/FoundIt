package com.luispedrolira.foundit.app.home

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToMissingObject: (String, String, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Contenido inicial de la pantalla
        Column {
            // Título superior
            Text(
                text = "¡Encuentra tus cosas perdidas!",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Nombre de la aplicación
            Text(
                text = "FoundIt",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Barra de búsqueda
            SearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            // Título para las categorías populares
            Text(
                text = "Categorías Populares",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Muestra las categorías populares
            PopularCategories()

            Spacer(modifier = Modifier.height(16.dp))

            // Título para los objetos perdidos
            Text(
                text = "Objetos perdidos",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Lista de objetos perdidos
            LostItemsList(onNavigateToMissingObject)
        }

        // Barra de navegación inferior
        BottomNavigationBar()
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
        // Muestra dos categorías populares como ejemplo
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
fun LostItemsList(onNavigateToMissingObject: (String, String, String) -> Unit) {
    // Ejemplo de elementos de la lista de objetos perdidos
    val items = listOf(
        Triple("Mochila negra", "Encontrado en biblioteca 10:30 am", "Mochila de color negro"),
        Triple("Audífonos Samsung", "Encontrado en cafetería", "Audífonos Samsung Galaxy Buds"),
        Triple("Teléfono plegable", "Encontrado en sala de estudio", "Samsung Galaxy Fold negro")
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            LostItemBox(
                title = item.first,
                location = item.second,
                description = item.third,
                onNavigateToMissingObject = onNavigateToMissingObject
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LostItemBox(
    title: String,
    location: String,
    description: String,
    onNavigateToMissingObject: (String, String, String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Caja gris simulando un ícono o imagen
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
            onClick = {
                onNavigateToMissingObject(title, location, description)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726))
        ) {
            Text(text = "MÁS DETALLES →", fontSize = 12.sp)
        }
    }
}

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
        // Botón de Home
        Box(
            modifier = Modifier
                .background(Color(0xFF4DB6AC), CircleShape)
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

        // Botón de búsqueda
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )

        // Botón de perfil
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        onNavigateToMissingObject = { _, _, _ -> }
    )
}
