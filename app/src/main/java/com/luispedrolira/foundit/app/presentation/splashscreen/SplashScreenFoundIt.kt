package com.luispedrolira.foundit.app.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.luispedrolira.foundit.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreenFoundIt(
    navController: NavController
) {
    // Navegación automática después de 3 segundos
    LaunchedEffect(Unit) {
        delay(3000) // Espera 3 segundos
        navController.navigate("homeScreen") {
            popUpTo("splashScreen") { inclusive = true } // Elimina SplashScreen del backstack
        }
    }

    // Diseño de la pantalla SplashScreen
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Imagen del logotipo
            Image(
                painter = painterResource(id = R.drawable.logofoundit), // Asegúrate de tener un recurso llamado "logo"
                contentDescription = "Logo de FoundIt",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Texto del título
            Text(
                text = "FoundIt",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtítulo o slogan
            Text(
                text = "¡Encuentra lo que perdiste fácilmente!",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    val navController = rememberNavController()
    SplashScreenFoundIt(navController = navController)
}
