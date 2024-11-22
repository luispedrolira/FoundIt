package com.luispedrolira.foundit.app.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luispedrolira.foundit.R
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeNavigation
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeViewModel
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeUiState
import com.luispedrolira.foundit.app.presentation.mainFlow.home.LostItem


@Composable
fun HomeScreen(
    onNavigate: (HomeNavigation) -> Unit,
    onNavigateToMissingObject: (String, String, String) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        when (uiState) {
            is HomeUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is HomeUiState.Success -> {
                Column {
                    Text(
                        text = "¡Encuentra tus cosas perdidas!",
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF4DB6AC),
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
                    Image(
                        painter = painterResource(id = R.drawable.logofoundit),
                        contentDescription = "Banner Bienvenida",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().height(150.dp)
                    )

                    // Objetos perdidos
                    Text(
                        text = "Objetos perdidos",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    LostItemsList(
                        items = (uiState as HomeUiState.Success).items,
                        onNavigateToMissingObject = onNavigateToMissingObject
                    )
                }
            }
            is HomeUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = (uiState as HomeUiState.Error).message,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            else -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Estado desconocido",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        BottomNavigationBar(onNavigate)
    }
}

@Composable
fun LostItemsList(
    items: List<LostItem>,
    onNavigateToMissingObject: (String, String, String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            LostItemBox(
                title = item.title,
                location = item.location,
                onDetailsClick = {
                    onNavigateToMissingObject(item.title, item.location, item.description)
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
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726)),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(4.dp)
        ) {
            Text(text = "MÁS DETALLES →", fontSize = 12.sp)
        }
    }
}

@Composable
fun BottomNavigationBar(onNavigate: (HomeNavigation) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(20.dp))
            .padding(horizontal = 45.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón de Home
        Box(
            modifier = Modifier
                .background(Color(0xFF4DB6AC), CircleShape)
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

        // Botón de perfil
        Box(
            modifier = Modifier
                .clickable { onNavigate(HomeNavigation.Profile) }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}