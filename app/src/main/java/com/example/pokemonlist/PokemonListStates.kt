package com.example.pokemonlist

import com.example.data.remote.model.pokemon.PokemonResponse

open class ImageListStates

object Loading : ImageListStates()

data class Failed(val error: Throwable) : ImageListStates()

data class ImageListLoaded(
    val data: PokemonResponse
) : ImageListStates() {
    companion object {
        fun from(
            data: PokemonResponse
        ): ImageListLoaded {
            return ImageListLoaded(data)
        }
    }
}