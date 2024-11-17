package com.luispedrolira.foundit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.luispedrolira.foundit.ui.theme.FoundItTheme
import com.luispedrolira.foundit.app.presentation.navigation.NavApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoundItTheme {
                NavApp() // Llamada a la clase NavApp
            }
        }
    }
}

