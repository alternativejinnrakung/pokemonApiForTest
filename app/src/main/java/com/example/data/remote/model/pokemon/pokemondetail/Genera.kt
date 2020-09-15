package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName

data class Genera (

	@SerializedName("genus") val genus : String,
	@SerializedName("language") val language : Language
)