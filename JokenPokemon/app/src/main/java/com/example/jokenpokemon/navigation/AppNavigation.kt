package com.example.jokenpokemon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jokenpokemon.ui.screens.JoKenPokemonScreen
import com.example.jokenpokemon.ui.screens.PlayerNameScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "name"
    ) {
        composable("name") {
            PlayerNameScreen(){ playerName ->
                navController.navigate("game/$playerName")
            }
        }

        composable("game/{playerName}",
            arguments = listOf(
                navArgument("playerName"){
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val playerName = backStackEntry.arguments?.getString("playerName") ?: "Desconhecido"
            JoKenPokemonScreen(playerName){
                navController.popBackStack()
            }
        }
    }
}