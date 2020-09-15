package com.example.domain

import com.example.data.remote.PokemonServices
import com.example.data.remote.model.pokemon.pokemondetail.PokemonDetailResponse

interface PokemonDetailRepository {
    suspend fun getPokemonDetail(pokemonId: String) : PokemonDetailResponse
}

class PokemonDetailRepositoryImpl(private val apiServices: PokemonServices) : PokemonDetailRepository {
    override suspend fun getPokemonDetail(pokemonId: String) : PokemonDetailResponse {
        return apiServices.getPokemonDetail(pokemonId)
    }
}