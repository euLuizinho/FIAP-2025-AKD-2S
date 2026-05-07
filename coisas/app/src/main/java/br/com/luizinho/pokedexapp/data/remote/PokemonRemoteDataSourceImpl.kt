package br.com.luizinho.pokedexapp.data.remote

import br.com.luizinho.pokedexapp.data.model.PokemonResponse

class PokemonRemoteDataSourceImpl (
    private val api: PokemonApi
) : PokemonRemoteDataSource {

    override suspend fun getPokemonByNumber(number: Int): PokemonResponse {
        return api.getPokemonByNumber(number)
    }
}