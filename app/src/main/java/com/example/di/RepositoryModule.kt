package com.example.di

import com.example.domain.PokemonDetailRepository
import com.example.domain.PokemonDetailRepositoryImpl
import com.example.domain.PokemonListRepository
import com.example.domain.PokemonRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<PokemonListRepository>(createdAtStart = true) { PokemonRepositoryImpl(get()) }
    single<PokemonDetailRepository>(createdAtStart = true) { PokemonDetailRepositoryImpl(get()) }
}