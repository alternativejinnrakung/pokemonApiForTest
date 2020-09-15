package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName

data class Growth_rate (

	@SerializedName("name") val name : String,
	@SerializedName("url") val url : String
)