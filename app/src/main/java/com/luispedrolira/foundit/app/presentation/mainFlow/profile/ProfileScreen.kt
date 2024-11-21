package com.luispedrolira.foundit.app.presentation.mainFlow.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Brush
import androidx.compose.material3.TextButton
import com.luispedrolira.foundit.R
import androidx.compose.foundation.Image


@Composable
fun ProfileRoute(onNavigateToHome: () -> Unit, onLogout: () -> Unit) {
    UserProfileScreen(
        email = "usuario@correo.com",
        onNavigateToHome = onNavigateToHome,
        onLogout = onLogout
    )
}

@Composable
fun UserProfileScreen(email: String, onNavigateToHome: () -> Unit, onLogout: () -> Unit) {
    val userName = email.substringBefore("@") // Extraer el nombre del correo

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Espaciado entre elementos (correo y botton)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Aplica el peso al contenido interior (hace que se ponga en el centro los textos)
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.user), // Imagen predeterminada
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFF9C4))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre de usuario
            Text(
                text = userName,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Correo del usuario
            Text(
                text = email,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Modifier.background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFE3F2FD), Color.White) // Azul claro a blanco
                )
            )

        }

        // Botón de cerrar sesión
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextButton(onClick = { onLogout() }) {
                Text(text = "Cerrar sesión", color = Color.Red)
            }
        }

        // Barra de navegación al final
        BottomNavigationBar(onNavigateToHome = onNavigateToHome)
    }
}

@Composable
fun BottomNavigationBar(onNavigateToHome: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(20.dp))
            .padding(horizontal = 45.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón de Home
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = Color.Black,
            modifier = Modifier
                .size(28.dp)
                .clickable { onNavigateToHome() } // Navega a Home
        )

        // Botón de perfil
        Box(
            modifier = Modifier
                .background(Color(0xFF4DB6AC), CircleShape) // Color turquesa
                .padding(13.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Perfil", color = Color.Black, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreen(
        email = "uwu@correo.com",
        onNavigateToHome = {},
        onLogout = {}
    )
}





