package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName

data class Color (

	@SerializedName("name") val name : String,
	@SerializedName("url") val url : String
)