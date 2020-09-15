package com.example.di

import com.example.pokemonlist.PokemonListViewModel
import com.example.pokemonlist.viewpokemon.ViewPokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PokemonListViewModel(get()) }
    viewModel { ViewPokemonViewModel(get()) }
}