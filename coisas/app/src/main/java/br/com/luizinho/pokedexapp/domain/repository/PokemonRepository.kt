package br.com.luizinho.pokedexapp.domain.repository

import br.com.luizinho.pokedexapp.domain.common.Resource
import br.com.luizinho.pokedexapp.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonByNumber(number: Int): Resource<Pokemon>
}