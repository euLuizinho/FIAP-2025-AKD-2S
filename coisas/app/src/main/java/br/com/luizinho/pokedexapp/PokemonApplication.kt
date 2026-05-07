package br.com.luizinho.pokedexapp

import android.app.Application
import br.com.luizinho.pokedexapp.di.dataModule
import br.com.luizinho.pokedexapp.di.domainModule
import br.com.luizinho.pokedexapp.di.networkModule
import br.com.luizinho.pokedexapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokemonApplication)

            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}