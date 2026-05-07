package br.com.luizinho.pokedexapp.data.remote

import br.com.luizinho.pokedexapp.data.model.PokemonResponse

interface PokemonRemoteDataSource {
    suspend fun getPokemonByNumber(number: Int): PokemonResponse
}