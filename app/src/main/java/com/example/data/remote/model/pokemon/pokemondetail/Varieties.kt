package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName
data class Varieties (

	@SerializedName("is_default") val is_default : Boolean,
	@SerializedName("pokemon") val pokemon : Pokemon
)