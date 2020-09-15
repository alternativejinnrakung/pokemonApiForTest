package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName

data class Flavor_text_entries (

	@SerializedName("flavor_text") val flavor_text : String,
	@SerializedName("language") val language : Language,
	@SerializedName("version") val version : Version
)