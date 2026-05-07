package br.com.luizinho.pokedexapp.di

import br.com.luizinho.pokedexapp.presentation.pokemon.detail.PokemonDetailViewModel
import br.com.luizinho.pokedexapp.presentation.pokemon.search.PokemonSearchScreen
import br.com.luizinho.pokedexapp.presentation.pokemon.search.PokemonSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        PokemonSearchViewModel()

    }

    viewModel {
        PokemonDetailViewModel(get())
    }


}
