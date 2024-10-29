package com.luispedrolira.foundit.adminapp.presentation.signupadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class SignUpAdminArgs(val username: String)

class RegistroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                SignUpAdminScreen(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpAdminScreen(navController: NavController) {
    var username by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Block de texto para el username
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        // Botón de "SIGN UP"
        Button(
            onClick = {
                val args = SignUpAdminArgs(username.text)
                val argsJson = Json.encodeToString(args)
                navController.navigate("dashboard/$argsJson")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
        ) {
            Text(text = "SIGN UP")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Texto de términos y condiciones
        Text(
            text = "By signing up, you agree to FoundIt's",
            fontSize = 12.sp
        )

        Row {
            Text(
                text = "Terms of Service",
                fontSize = 12.sp,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { /* Abrir términos de servicio */ }
            )

            Text(
                text = " and ",
                fontSize = 12.sp
            )

            Text(
                text = "Privacy Policy.",
                fontSize = 12.sp,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { /* Abrir política de privacidad */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpAdminScreen() {
    val navController = rememberNavController()
    SignUpAdminScreen(navController = navController)
}


