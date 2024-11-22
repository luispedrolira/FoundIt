package com.luispedrolira.foundit.app.presentation.mainFlow.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.luispedrolira.foundit.R

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
            // Logo de la app
            Image(
                painter = painterResource(id = R.drawable.logofoundit),
                contentDescription = "Logo de FoundIt",
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp)
            )

            // Título superior
            Text(
                text = "¡Encuentra tus cosas perdidas!",
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            Text(
                text = "FoundIt",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Objetos perdidos
            Text(
                text = "Objetos perdidos",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            LostItemsList(onNavigateToMissingObject)
        }

        // Nuevo diseño de navegación inferior
        BottomNavigationBar(onNavigate)
    }
}

@Composable
fun BottomNavigationBar(onNavigate: (HomeNavigation) -> Unit) {
    val customHomeColor = Color(0xFF4DB6AC)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(24.dp))
            .padding(horizontal = 20.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón de Home
        Box(
            modifier = Modifier
                .background(customHomeColor, RoundedCornerShape(50))
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable { onNavigate(HomeNavigation.Home) },
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Home",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }

        // Botón de Perfil
        Box(
            modifier = Modifier
                .clickable { onNavigate(HomeNavigation.Profile) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Perfil",
                tint = Color.Gray,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun LostItemsList(
    onNavigateToMissingObject: (String, String, String) -> Unit
) {
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

@Composable
fun LostItemBox(
    title: String,
    location: String,
    onDetailsClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onDetailsClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = location,
                    fontSize = 14.sp,
                    color = Color(0xFF333333) // Color más opaco que el negro
                )
            }

            Button(
                onClick = onDetailsClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(text = "MÁS DETALLES", fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onNavigate = { /* Handle navigation */ },
        onNavigateToMissingObject = { _, _, _ -> /* Handle missing object navigation */ }
    )
}
