package com.example.jokenpokemon.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.jokenpokemon.R

@Composable
fun PokemonLogo (modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.pokemon_logo),
        contentDescription = "Logo do pokémon"
    )
}