package com.luispedrolira.foundit.app.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.luispedrolira.foundit.R

@Composable
fun WelcomeRoute(
    onLoginClick: () -> Unit, // Esta función ya no se utilizará, se elimino el button.
    onRegisterClick: () -> Unit
) {
    WelcomeScreen(
        onLoginClick = onLoginClick, // Esta función ya no se utilizará, se elimino el button.
        onRegisterClick = onRegisterClick,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun WelcomeScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // SECCIÓN No 1: Logo de FoundIt
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logofoundit),
                contentDescription = "Logo de FoundIt",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // SECCIÓN No 2: Bienvenida a FoundIt
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¡Bienvenido a",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "FOUNDIT!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Encuentra lo que buscas acá",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // SECCIÓN No 3: Crear cuenta o iniciar sesión
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onRegisterClick, // Navega al Registro
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "REGISTRATE")
                }
            }
        }
    }
}
