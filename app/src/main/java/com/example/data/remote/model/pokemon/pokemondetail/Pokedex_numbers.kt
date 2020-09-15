package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName
data class Pokedex_numbers (

	@SerializedName("entry_number") val entry_number : Int,
	@SerializedName("pokedex") val pokedex : Pokedex
)