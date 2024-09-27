package com.luispedrolira.foundit.app.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luispedrolira.foundit.R

@Composable
private fun WelcomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Imagen de bienvenida
        Image(
            painter = painterResource(id = R.drawable.logofoundit),
            contentDescription = "Imagen de brújula",
            modifier = Modifier.size(200.dp) // Ajusta el tamaño de la imagen
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre imagen y texto

        // Texto de bienvenida
        Text(
            text = "Bienvenido A",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "FOUNDIT!",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre el título y el subtítulo

        // Subtítulo
        Text(
            text = "Encuentra lo que buscas acá",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp)) // Espacio entre el texto y los botones

        // Botones de Login y Registro en fila
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* Acción de Login */ },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text(text = "LOG IN")
            }

            Button(
                onClick = { /* Acción de Registro */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "REGISTRO")
            }
        }
    }
}


@Preview
@Composable
private fun PreviewWelcomeScreen() {
    Surface {
        WelcomeScreen()
    }
}