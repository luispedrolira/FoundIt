package com.luispedrolira.foundit.app.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeNavigation
import androidx.compose.ui.tooling.preview.Preview
import com.luispedrolira.foundit.R
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale


@Composable
fun HomeScreen(
    onNavigate: (HomeNavigation) -> Unit,
    onNavigateToMissingObject: (String, String, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            // Título superior
            Text(
                text = "¡Encuentra tus cosas perdidas!",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "FoundIt",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Categorías populares
            Text(
                text = "Categorías Populares",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            PopularCategories(onNavigate)

            Spacer(modifier = Modifier.height(16.dp))

            // Objetos perdidos
            Text(
                text = "Objetos perdidos",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LostItemsList(onNavigateToMissingObject)
        }

        // Barra de navegación inferior
        BottomNavigationBar(onNavigate)
    }
}

@Composable
fun BottomNavigationBar(onNavigate: (HomeNavigation) -> Unit) {
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
                .background(Color(0xFF4DB6AC), CircleShape) // Color turquesa
                .padding(12.dp)
                .clickable { onNavigate(HomeNavigation.Home) }
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
        Box(
            modifier = Modifier
                .clickable { onNavigate(HomeNavigation.Search("")) }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }

        // Botón de perfil
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun PopularCategories(onNavigate: (HomeNavigation) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Categorías populares con imágenes y navegación
        CategoryImage("Cargadores", R.drawable.cargadores) { onNavigate(HomeNavigation.Search("Cargadores")) }
        CategoryImage("Mochilas", R.drawable.mochila) { onNavigate(HomeNavigation.Search("Mochilas")) }
    }
}

@Composable
fun CategoryImage(title: String, imageRes: Int, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(150.dp, 100.dp)
            .background(Color(0xFF4DB6AC), RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .padding(2.dp)
    ) {
        // Imagen en lugar de texto
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .size(150.dp, 100.dp)
                .clickable { onClick() }
                .padding(6.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun LostItemsList(
    onNavigateToMissingObject: (String, String, String) -> Unit
) {
    // Ejemplo de elementos de la lista de objetos perdidos
    val items = listOf(
        "Mochila negra" to "Encontrado en biblioteca 10:30 am",
        "Audífonos Samsung" to "Encontrado en cafetería",
        "Teléfono plegable" to "Encontrado en sala de estudio"
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            LostItemBox(
                title = item.first,
                location = item.second,
                onDetailsClick = {
                    onNavigateToMissingObject(item.first, item.second, "Descripción del objeto")
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LostItemBox(
    title: String,
    location: String,
    onDetailsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Caja gris como un ícono o imagen
        Image(
            painter = painterResource(id = R.drawable.perdido),
            contentDescription = "Cosas Perdidas",
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
                fontSize = 16.sp
            )
            Text(
                text = location,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
        // Botón para navegar a MissingObjectScreen
        Button(
            onClick = onDetailsClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726))
        ) {
            Text(text = "MÁS DETALLES →", fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // You can pass mock navigation actions as parameters
    HomeScreen(
        onNavigate = { /* Handle navigation */ },
        onNavigateToMissingObject = { _, _, _ -> /* Handle missing object navigation */ }
    )
}


