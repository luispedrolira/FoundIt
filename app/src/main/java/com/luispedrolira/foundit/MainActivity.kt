package com.luispedrolira.foundit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.Dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.luispedrolira.foundit.adminapp.presentation.signupadmin.signUpAdminNavGraph
import com.luispedrolira.foundit.ui.theme.FoundItTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoundItTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White //Color random para visualizacion
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "signUpAdminRoute",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        signUpAdminNavGraph(navController)
                    }
                }
            }
        }
    }
}
