package com.luispedrolira.foundit.adminapp.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.luispedrolira.foundit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardContent1(onObjectClick: (Objeto) -> Unit, navController: NavController) {
    val objetos = remember {
        mutableStateListOf(
            Objeto("Mochila", "Encontrado en biblioteca 10:30 am", R.drawable.mochila),
            Objeto("Audífonos", "Encontrado en cafetería", R.drawable.audifonos),
            Objeto("Teléfono", "Encontrado en el salón 512", R.drawable.telefono)
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Administrar objetos", fontWeight = FontWeight.Bold) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("newObject") }) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(objetos) { objeto ->
                ObjetoItem(
                    objeto = objeto,
                    onClick = { onObjectClick(objeto) },
                    onDelete = { objetos.remove(objeto) }
                )
            }
        }
    }
}

@Composable
fun ObjetoItem(objeto: Objeto, onClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = objeto.imagenResourceId),
                contentDescription = objeto.nombre,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 8.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = objeto.nombre, fontWeight = FontWeight.Bold)
                Text(text = objeto.ubicacion)
            }
            Button(
                onClick = onDelete,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Eliminar")
            }
        }
    }
}
