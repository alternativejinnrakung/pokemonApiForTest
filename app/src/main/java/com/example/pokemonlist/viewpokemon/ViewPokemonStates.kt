package com.example.pokemonlist.viewpokemon

import com.example.data.remote.model.pokemon.pokemondetail.PokemonDetailResponse

open class ViewPokemonStates

object Loading : ViewPokemonStates()

data class Failed(val error: Throwable) : ViewPokemonStates()

data class isDetailLoaded(
    val data: PokemonDetailResponse
) : ViewPokemonStates() {
    companion object {
        fun from(
            data: PokemonDetailResponse
        ): isDetailLoaded {
            return isDetailLoaded(data)
        }
    }
}