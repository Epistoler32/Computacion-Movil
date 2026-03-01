package com.example.myapplication.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuessGame(navController: NavController) {

    var randomNumber by remember { mutableStateOf(Random.nextInt(1, 101)) }
    var userInput by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var attempts by remember { mutableStateOf(0) }
    var gameFinished by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Guess Game") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6A1B9A), // Morado
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Adivina el número (1 - 100)",
                fontSize = 22.sp,
                color = Color.Blue
            )

            OutlinedTextField(
                value = userInput,
                onValueChange = { userInput = it },
                enabled = !gameFinished,
                label = { Text("Ingresa un número") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val guess = userInput.toIntOrNull()
                    if (guess != null) {
                        attempts++

                        when {
                            guess < randomNumber -> {
                                message = "Mayor que $guess"
                            }
                            guess > randomNumber -> {
                                message = "Menor que $guess"
                            }
                            else -> {
                                message = "El numero es $guess"
                                gameFinished = true
                            }
                        }
                    }
                },
                enabled = !gameFinished
            ) {
                Text("Jugar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mensaje mayor/menor
            Text(
                text = message,
                color = if (gameFinished) Color.Green else Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Contador debajo del mensaje
            Text("Intentos: $attempts")

            Spacer(modifier = Modifier.height(24.dp))

            if (gameFinished) {
                FloatingActionButton(
                    onClick = {
                        randomNumber = Random.nextInt(1, 201)
                        userInput = ""
                        message = ""
                        attempts = 0
                        gameFinished = false
                    }
                ) {
                    Icon(
                        Icons.Filled.Refresh,
                        "reiniciar")
                }
            }
        }
    }
}