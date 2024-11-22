package com.luispedrolira.foundit.app.missingObject

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MissingObjectScreen(
    category: String,
    location: String,
    description: String,
    onBackClick: () -> Unit,
    viewModel: MissingObjectViewModel = viewModel()
) {
    // Actualizar el estado con los parámetros recibidos
    viewModel.updateMissingObject(category, location, description)

    // Observar el estado del objeto perdido
    val missingObjectState by viewModel.missingObjectState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Botón de regreso <-
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Regresar"
            )
        }

        // Título
        Text(
            text = "Objeto perdido",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 24.dp)
        )

        // Información del objeto
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InfoRow(label = "Categoría:", value = missingObjectState.category)
            InfoRow(label = "Ubicación:", value = missingObjectState.location)
            InfoRow(label = "Descripción:", value = missingObjectState.description)
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = value,
            modifier = Modifier.weight(1f)
        )
    }
}




