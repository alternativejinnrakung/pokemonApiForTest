package com.example.domain

import com.example.data.remote.PokemonServices
import com.example.data.remote.model.pokemon.PokemonResponse

interface PokemonListRepository {
    suspend fun getPokemonList() : PokemonResponse
}

class PokemonRepositoryImpl(private val apiServices: PokemonServices) : PokemonListRepository {
    override suspend fun getPokemonList() : PokemonResponse {
        return apiServices.getPokemonList()
    }
}