package br.com.luizinho.pokedexapp.di

import br.com.luizinho.pokedexapp.domain.usecase.GetPokemonByNumberUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetPokemonByNumberUseCase(repository = get())
    }
}