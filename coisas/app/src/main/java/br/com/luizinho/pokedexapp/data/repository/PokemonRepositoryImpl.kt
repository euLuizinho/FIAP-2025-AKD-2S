package br.com.luizinho.pokedexapp.data.repository

import br.com.luizinho.pokedexapp.data.model.toDomain
import br.com.luizinho.pokedexapp.data.remote.PokemonRemoteDataSource
import br.com.luizinho.pokedexapp.domain.common.Resource
import br.com.luizinho.pokedexapp.domain.model.Pokemon
import br.com.luizinho.pokedexapp.domain.repository.PokemonRepository

class PokemonRepositoryImpl (
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemonByNumber(number: Int): Resource<Pokemon> {
        return try {
            val response = remoteDataSource.getPokemonByNumber(number)
            Resource.Success(response.toDomain())
        } catch (exception: Exception) {
            Resource.Error("Não foi possível buscar o Pokémon.")
        }
    }
}

