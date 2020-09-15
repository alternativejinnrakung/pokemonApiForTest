package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName

data class Pal_park_encounters (

	@SerializedName("area") val area : Area,
	@SerializedName("base_score") val base_score : Int,
	@SerializedName("rate") val rate : Int
)