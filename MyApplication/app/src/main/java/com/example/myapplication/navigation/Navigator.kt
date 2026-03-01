package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.GuessGame
import com.example.myapplication.screens.Home

enum class AppScreens{
    Home,
    Guess;
}

@Composable
fun Navigator(){
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination=AppScreens.Home.name){
        composable(route=AppScreens.Home.name){
            Home(navController)
        }
        composable(route= AppScreens.Guess.name){
            GuessGame(navController)
        }
    }
}