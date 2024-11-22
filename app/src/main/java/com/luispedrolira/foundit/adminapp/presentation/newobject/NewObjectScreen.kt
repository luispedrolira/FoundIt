package com.luispedrolira.foundit.adminapp.presentation.newobject

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luispedrolira.foundit.adminapp.presentation.dashboard.Objeto

@Composable
fun NewObjectContent(
    onBackClick: () -> Unit,
    navController: NavController,
    addObject: (Objeto) -> Unit
) {
    var categoria by remember { mutableStateOf("") }
    var lugar by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        // Botón para regresar
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar")
        }

        // Título
        Text(
            text = "Ingresa objetos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campos de texto para ingresar los datos
        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoría del objeto") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = lugar,
            onValueChange = { lugar = it },
            label = { Text("Lugar donde fue encontrado") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción del objeto") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botón para publicar el objeto
        Button(
            onClick = {
                val nuevoObjeto = com.luispedrolira.foundit.adminapp.presentation.dashboard.Objeto(
                    nombre = categoria,
                    ubicacion = lugar
                )
                addObject(nuevoObjeto)
                navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp)
        ) {
            Text("Publicar")
        }
    }
}

fun addObject(nuevoObjeto: com.luispedrolira.foundit.adminapp.presentation.dashboard.Objeto) {
    TODO("Not yet implemented")
}
