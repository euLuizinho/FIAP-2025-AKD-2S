package br.com.luizinho.pokedexapp.data.remote

import br.com.luizinho.pokedexapp.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon/{number}")
    suspend fun getPokemonByNumber(
        @Path("number") number: Int
    ): PokemonResponse
}