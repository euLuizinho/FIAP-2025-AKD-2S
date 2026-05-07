package br.com.luizinho.pokedexapp.di

// Manter o package
// Fazer os imports

import br.com.luizinho.pokedexapp.data.remote.PokemonRemoteDataSource
import br.com.luizinho.pokedexapp.data.remote.PokemonRemoteDataSourceImpl
import br.com.luizinho.pokedexapp.data.repository.PokemonRepositoryImpl
import br.com.luizinho.pokedexapp.domain.repository.PokemonRepository
import org.koin.dsl.module

val dataModule = module {

    single<PokemonRemoteDataSource> {
        PokemonRemoteDataSourceImpl(api = get())
    }

    single<PokemonRepository> {
        PokemonRepositoryImpl(remoteDataSource = get())
    }
}