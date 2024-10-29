package com.luispedrolira.foundit.app.presentation.mainFlow.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.formatWithSkeleton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luispedrolira.foundit.app.presentation.mainFlow.home.SearchBar


@Composable
fun SearchRoute(){

}


@Composable
private fun SearchScreen(state: Int){
    when (state){
        1 -> NoResults()
        2 -> Results()
    }

}

@Composable
private fun NoResults(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Column {
            Text(
                text = "Buscar",
                style = MaterialTheme.typography.displayMedium
            )
            SearchBar()
        }
        SearchBottomNavigationBar()
    }
}

@Composable
private fun Results(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Column {
            Text(
                text = "Buscar",
                style = MaterialTheme.typography.displayMedium
            )
            SearchBar()


            LazyVerticalGrid(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                columns = GridCells.Fixed(3)
            ) {

                items(15){
                    ExampleResult()
                }
            }

        }
        SearchBottomNavigationBar()
    }
}

@Composable
private fun ExampleResult(){
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray, RoundedCornerShape(10.dp))
    )
}

@Composable
fun SearchBottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Boton de Home (parte inferior)
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )


        // Boton de busqueda (sin fondo)
        Box(
            modifier = Modifier
                .background(Color(0xFF4DB6AC), CircleShape) // Color turquesa
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Buscar", color = Color.Black, fontSize = 14.sp)
            }
        }


        // Boton de perfil (sin fondo)
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
    }
}



@Preview
@Composable
private fun PreviewSearchScreen() {
    Surface {
        SearchScreen(
            state = 2
        )
    }
}