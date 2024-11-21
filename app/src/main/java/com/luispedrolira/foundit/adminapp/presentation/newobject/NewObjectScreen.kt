package com.luispedrolira.foundit.adminapp.presentation.newobject

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luispedrolira.foundit.R

@Composable
fun NewObjectContent(navController: NavController) {
    var categoria by remember { mutableStateOf("") }
    var lugar by remember { mutableStateOf("") }
    var nombreEstudiante by remember { mutableStateOf("") }
    var carneEstudiante by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ingresa objetos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Placeholder para la imagen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray), // Color de fondo
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Subir Imagen", color = Color.White) // Texto predeterminado
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Campos de entrada
        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoría") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lugar,
            onValueChange = { lugar = it },
            label = { Text("Lugar") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = nombreEstudiante,
            onValueChange = { nombreEstudiante = it },
            label = { Text("Nombre del Estudiante") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = carneEstudiante,
            onValueChange = { carneEstudiante = it },
            label = { Text("Carné del Estudiante") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Publicar")
        }
    }
}
