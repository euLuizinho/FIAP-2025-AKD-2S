package br.com.luizinho.pokedexapp.domain.usecase

import br.com.luizinho.pokedexapp.domain.common.Resource
import br.com.luizinho.pokedexapp.domain.model.Pokemon
import br.com.luizinho.pokedexapp.domain.repository.PokemonRepository

class GetPokemonByNumberUseCase (
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(number: Int): Resource<Pokemon> {
        if (number <= 0) {
            return Resource.Error("Informe um número maior que zero.")
        }

        if (number > 1025) {
            return Resource.Error("Informe um número válido até 1025.")
        }

        return repository.getPokemonByNumber(number)
    }
}