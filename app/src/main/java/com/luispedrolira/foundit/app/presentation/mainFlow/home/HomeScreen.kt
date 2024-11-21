package com.luispedrolira.foundit.app.presentation.mainFlow.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luispedrolira.foundit.app.presentation.navigation.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (HomeNavigation) -> Unit,
    onNavigateToMissingObject: (String, String, String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("¡Encuentra tus cosas perdidas!") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            BottomNavBar(onNavigate)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                // Título principal
                Text(
                    text = "FoundIt",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Categorías populares
                Text(
                    text = "Categorías Populares",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                PopularCategories(onNavigate)

                Spacer(modifier = Modifier.height(16.dp))

                // Objetos perdidos
                Text(
                    text = "Objetos perdidos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                LostItemsList(onNavigateToMissingObject)
            }
        }
    }
}

fun BottomNavBar(checkItemSelected: (HomeNavigation) -> Unit) {
    TODO("Not yet implemented")
}

@Composable
fun PopularCategories(onNavigate: (HomeNavigation) -> Unit) {

}

@Composable
fun LostItemsList(onNavigateToMissingObject: (String, String, String) -> Unit) {
}
