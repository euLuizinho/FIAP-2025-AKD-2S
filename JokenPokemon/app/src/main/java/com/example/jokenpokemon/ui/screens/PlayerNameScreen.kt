package com.example.jokenpokemon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jokenpokemon.ui.components.PokemonLogo

@Composable
fun PlayerNameScreen (
    onStartGame: (String) -> Unit
) {

    var playerName by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .background(Color(0xFFFDF79B))
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        PokemonLogo()

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = playerName,
            onValueChange = { playerName = it },
            label = { Text("Digite seu nome") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onStartGame(playerName)},
            enabled = playerName.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Batalha")
        }

    }
}

@Preview
@Composable
private fun PlayerNameScreenPreview() {
    PlayerNameScreen(){

    }
}