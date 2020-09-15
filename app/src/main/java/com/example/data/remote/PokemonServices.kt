package com.example.data.remote

import com.example.data.remote.model.pokemon.PokemonResponse
import com.example.data.remote.model.pokemon.pokemondetail.PokemonDetailResponse
import retrofit2.http.*

interface PokemonServices {
    @GET("pokedex/2/")
    suspend fun getPokemonList() : PokemonResponse

    @GET("pokemon-species/{pokemonId}")
    suspend fun getPokemonDetail(
        @Path("pokemonId"
        ) pokemonId: String) : PokemonDetailResponse
}