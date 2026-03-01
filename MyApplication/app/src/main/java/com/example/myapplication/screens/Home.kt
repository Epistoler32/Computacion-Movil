package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R

@Composable
fun Home(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ElevatedCard(
            onClick = {navController.navigate("Guess")},
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            elevation = CardDefaults.elevatedCardElevation()
        ) {
            Image(painter = painterResource(id = R.drawable.numbers),
                contentDescription = "Juego Números",
                modifier = Modifier.fillMaxWidth().height(180.dp)
            )
        }

        ElevatedCard(
            onClick = {},
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            elevation = CardDefaults.elevatedCardElevation()
        ) {
            Image(
                painter = painterResource(id = R.drawable.driver),
                contentDescription = "Piloto",
                modifier = Modifier.fillMaxWidth().height(180.dp)
            )
        }
    }
}