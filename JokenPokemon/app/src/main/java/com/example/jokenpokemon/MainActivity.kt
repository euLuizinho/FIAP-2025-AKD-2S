package com.example.jokenpokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jokenpokemon.navigation.AppNavigation
import com.example.jokenpokemon.ui.theme.JokenPokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokenPokemonTheme {
               AppNavigation()
            }
        }
    }
}

